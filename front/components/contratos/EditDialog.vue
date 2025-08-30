<template>
  <v-dialog
    v-model="editDialog"
    max-width="700px"
  >
    <v-card class="px-2">
      <v-card-title class="d-flex align-center justify-space-between">
        <span>{{ dialogProps.item.id ? 'Editar Usuário' : 'Novo Usuário' }}</span>
        <v-btn
          id="btn-close-dialog"
          icon
          flat
          :disabled="loading"
          @click="closeDialog"
        >
          <v-icon> mdi-close </v-icon>
        </v-btn>
      </v-card-title>
      <v-divider />
      <v-card-text>
        <v-form
          ref="userForm"
          v-model="isFormValid"
        >
          <v-row class="mt-2 ga-3">
            <v-text-field
              v-model="form.name"
              label="Nome"
              :rules="[rules.required]"
              required
            />
            <v-text-field
              v-model="form.registry"
              v-maska="'###.###.###-##'"
              label="CPF"
              :rules="[rules.required, rules.isCpf]"
              :disabled="!!dialogProps.item.id"
              required
            />
          </v-row>
          <v-row class="mt-2 ga-3">
            <v-text-field
              v-model="form.email"
              label="Email"
              :rules="[rules.email]"
            />
            <v-text-field
              v-model="form.phone"
              label="Telefone"
            />
          </v-row>
          <v-row class="mt-2 ga-3">
            <v-text-field
              v-model="form.address"
              label="Endereço"
            />
          </v-row>
          <v-row class="mt-2 ga-3">
            <v-select
              v-model="form.profile_id"
              :items="profiles"
              item-title="name"
              item-value="id"
              label="Perfil"
            />
            <v-switch
              v-if="form.id"
              v-model="form.is_active"
              label="Ativo?"
              color="success"
            />
          </v-row>
        </v-form>
      </v-card-text>
      <v-divider />
      <v-card-actions>
        <v-btn
          variant="outlined"
          @click="clear"
        >
          Limpar
        </v-btn>
        <v-btn
          :disabled="!isFormValid"
          variant="flat"
          color="green"
          @click="submit"
        >
          Salvar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useUserService } from '@/services/users'

const { createUser, updateUser } = useUserService()

const emit = defineEmits(['close-dialog', 'reload-table'])
const dialogProps = defineProps({
  dialog: {
    type: Boolean,
    default: false,
  },
  item: {
    type: Object,
    default: () => {},
  },
})
const editDialog = ref(false)
const isFormValid = ref(false)
const loading = ref(false)
const rules = {
  required: v => !!v || 'Campo obrigatório',
  email: v => /.+@.+\..+/.test(v) || 'Email inválido',
  isCpf: v => v.length === 14 || 'CPF Inválido',
}
const profiles = ref([{ id: 1, name: 'Locatário' }, { id: 2, name: 'Locador' }])
const form = ref({
  id: null,
  name: '',
  registry: '',
  email: '',
  phone: '',
  address: '',
  is_active: false,
  profile_id: null,
})

watch(
  () => dialogProps.dialog,
  (value) => {
    if (value) {
      editDialog.value = value
    }
  },
)
watch(
  () => dialogProps.item,
  (value) => {
    if (value) {
      form.value = { ...dialogProps.item, profile_id: value.profile?.id }
    }
  },
)

function closeDialog() {
  editDialog.value = false
  emit('close-dialog')
}
function clear() {
  form.value = Object.assign(dialogProps.item, {})
}
function submit() {
  if (form.value.id) {
    updateUser(form.value.id, form.value).then(() => {
      closeDialog()
      emit('reload-table')
    })
  }
  else {
    createUser(form.value).then(() => {
      closeDialog()
      emit('reload-table')
    })
  }
}
</script>
