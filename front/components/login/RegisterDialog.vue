<template>
  <v-dialog
    v-model="dialog"
    max-width="600"
    persistent
  >
    <v-card
      rounded="xl"
      class="pa-4"
    >
      <v-card-title class="text-h5 text-center font-weight-bold">
        Criar uma Conta
      </v-card-title>
      <v-card-text>
        <v-form @submit.prevent="createUser">
          <v-text-field
            v-model="form.name"
            label="Nome Completo"
            variant="outlined"
            required
            rounded="xl"
            class="mb-0"
          />
          <v-text-field
            v-model="form.registry"
            label="CPF / CNPJ"
            variant="outlined"
            required
            rounded="xl"
            class="mb-0"
          />
          <v-text-field
            v-model="form.email"
            label="E-mail"
            type="email"
            variant="outlined"
            required
            rounded="xl"
            class="mb-0"
          />
          <v-text-field
            v-model="form.phone"
            label="Telefone"
            variant="outlined"
            rounded="xl"
            class="mb-0"
          />
          <v-text-field
            v-model="form.address"
            label="Endereço"
            variant="outlined"
            rounded="xl"
            class="mb-0"
          />
          <v-text-field
            v-model="form.password"
            class="mb-0"
            label="Senha"
            :type="showPassword ? 'text' : 'password'"
            variant="outlined"
            rounded="xl"
            required
            :append-inner-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append-inner="showPassword = !showPassword"
          />
          <v-text-field
            v-model="form.confirmPassword"
            class="mb-0"
            label="Confirmar Senha"
            :type="showConfirmPassword ? 'text' : 'password'"
            variant="outlined"
            required
            rounded="xl"
            :append-inner-icon="showConfirmPassword ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.passwordsMatch(form.password, form.confirmPassword)]"
            @click:append-inner="showConfirmPassword = !showConfirmPassword"
          />
          <v-btn
            type="submit"
            color="primary"
            block
            rounded="xl"
            size="large"
            class="mt-4"
          >
            Cadastrar
          </v-btn>
        </v-form>
      </v-card-text>
      <v-card-actions class="justify-center">
        <v-btn
          color="grey-darken-1"
          variant="text"
          @click="close"
        >
          Cancelar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup>
import { useAuthService } from '~/services/auth'

const emit = defineEmits(['update:modelValue'])
const props = defineProps({
  modelValue: {
    type: Boolean,
    required: true,
  },
})

const { register } = useAuthService()
const { rules } = useValidationRules()
const dialog = computed({
  get: () => props.modelValue,
  set: value => emit('update:modelValue', value),
})

const form = reactive({
  name: '',
  registry: '',
  email: '',
  phone: '',
  address: '',
  password: '',
  confirmPassword: '',
})
const showPassword = ref(false)
const showConfirmPassword = ref(false)

const createUser = () => {
  if (form.password !== form.confirmPassword) {
    alert('As senhas não coincidem.')
    return
  }

  console.log('Dados do cadastro:', form)

  close()
}

const close = () => {
  dialog.value = false
}
</script>
