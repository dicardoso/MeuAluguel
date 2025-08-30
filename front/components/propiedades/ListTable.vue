<template>
  <v-card
    class="pa-4 ma-2 w-100"
    rounded="xl"
  >
    <v-card-title class="d-flex align-center justify-space-between">
      Pessoas
      <v-btn
        color="primary"
        prepend-icon="mdi-plus"
        rounded="xl"
        @click="openDialog()"
      >
        Nova Pessoa
      </v-btn>
    </v-card-title>
    <v-data-table
      v-model:sort-by="sortBy"
      :headers="headers"
      :items="users"
      :loading="loading"
      item-value="id"
    >
      <template #[`item.registry`]="{ item }">
        <span> {{ applyMask(item.registry, '###.###.###-##') }} </span>
      </template>
      <template #[`item.is_active`]="{ item }">
        <v-chip
          :color="item.is_active ? 'green' : 'red'"
          dark
        >
          {{ item.is_active ? 'Ativo' : 'Inativo' }}
        </v-chip>
      </template>
      <template #[`item.actions`]="{ item }">
        <utils-tooltip>
          <template #button>
            <v-btn
              density="comfortable"
              variant="text"
              icon="mdi-pencil-outline"
              @click="openDialog(item)"
            />
          </template>
          <template #text>
            <span>Editar</span>
          </template>
        </utils-tooltip>
      </template>
    </v-data-table>
  </v-card>
</template>

<script setup>
import { useUserService } from '@/services/users'

const emit = defineEmits(['open-dialog', 'table-loaded'])
const listProps = defineProps({
  reloadTable: {
    type: Boolean,
    default: false,
  },
})

const { getUser } = useUserService()
const users = ref([])
const loading = ref(false)
const sortBy = ref([{ key: 'id', order: 'asc' }])
const headers = [
  { title: 'ID', value: 'id', sortable: true },
  { title: 'Nome', value: 'name', sortable: true },
  { title: 'Registro', value: 'registry' },
  { title: 'Email', value: 'email' },
  { title: 'Telefone', value: 'phone' },
  { title: 'Endereço', value: 'address' },
  { title: 'Perfil', value: 'profile.name', sortable: true },
  { title: 'Status', value: 'is_active', sortable: true },
  { title: 'Ações', value: 'actions' },
]

function initialize() {
  loading.value = true
  getUser({ sort: 'id' }).then((data) => {
    users.value = data
    emit('table-loaded')
  }).finally(() => {
    loading.value = false
  })
}
function openDialog(item) {
  emit('open-dialog', item)
}
watch(
  () => listProps.reloadTable,
  (value) => {
    if (value) {
      initialize()
    }
  },
)
initialize()
</script>
