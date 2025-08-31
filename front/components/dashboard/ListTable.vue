<template>
  <v-card
    class="pa-4"
    rounded="xl"
  >
    <v-card-title class="d-flex align-center justify-space-between">
      Contratos
      <v-btn
        :to="{ path: '#' }"
        color="primary"
        prepend-icon="mdi-plus"
        rounded="xl"
      >
        Novo Contrato
      </v-btn>
    </v-card-title>
    <v-data-table-server
      v-if="contractStore.contracts.length > 0"
      v-model:items-per-page="itemsPerPage"
      :headers="headers"
      :items="contractStore.contracts"
      :items-length="contractStore.contracts.length"
      :loading="loading"
      :search="search"
      item-value="name"
      class="mt-4"
      @update:options="loadItems"
    >
      <template #[`item.status`]="{ item }">
        <v-chip
          :color="getStatusColor(item.status)"
          class="text-capitalize"
        >
          {{ item.status }}
        </v-chip>
      </template>
      <template #[`item.property`]="{ item }">
        {{ item.property.address }}{{ item.property.complement ? ', ' + item.property.complement : '' }}
      </template>
      <template #[`item.actions`]="{ item }">
        <contratos-action-buttons
          :item="item"
        />
      </template>
    </v-data-table-server>
    <div
      v-else
      class="text-center text-grey-darken-1 py-10"
    >
      <p>Nenhum contrato encontrado.</p>
    </div>
  </v-card>
</template>

<script setup lang="ts">
import type { ContractType } from '~/types/contracts'

const contractStore = reactive({
  contracts: [
    { id: 1, renterName: { name: 'João Silva' }, property: { address: 'Apto, 2001', complement: '' }, start_date: '2023-01-15', end_date: '2024-01-14', monthlyRent: 1500.00, status: 'Ativo' },
    { id: 2, renterName: { name: 'Maria Souza' }, property: { address: 'Casa', complement: 'A' }, start_date: '2023-03-01', end_date: '2023-11-14', monthlyRent: 2200.00, status: 'Encerrado' },
    { id: 3, renterName: { name: 'Carlos Lima' }, property: { address: 'Office', complement: '' }, start_date: '2023-05-20', end_date: '2024-05-19', monthlyRent: 1850.00, status: 'Vencendo' },
    { id: 4, renterName: { name: 'Ana Maria' }, property: { address: 'Loja, 32', complement: '' }, start_date: '2024-01-01', end_date: '2025-01-01', monthlyRent: 3000.00, status: 'Ativo' },
    { id: 5, renterName: { name: 'Pedro Martins' }, property: { address: 'Apartamento', complement: '' }, start_date: '2023-09-10', end_date: '2024-09-09', monthlyRent: 1900.00, status: 'Ativo' },
    { id: 6, renterName: { name: 'Juliana Costa' }, property: { address: 'Studio', complement: '' }, start_date: '2024-03-01', end_date: '2025-02-28', monthlyRent: 1200.00, status: 'Vencendo' },
    { id: 7, renterName: { name: 'Rafael Gomes' }, property: { address: 'Casa de Campo', complement: '' }, start_date: '2022-07-01', end_date: '2023-06-30', monthlyRent: 2500.00, status: 'Encerrado' },
  ],

  nextId: 8,
})
const modal = reactive({ show: false, title: '', message: '', type: 'info' })
const confirmDelete = ref(false)
const itemToDelete = ref<ContractType | null>(null)
const router = useRouter()

// Configuração da tabela
const itemsPerPage = ref(5)
const headers = ref([
  { title: 'Inquilino', key: 'renterName.name' },
  { title: 'Imóvel', key: 'property' },
  { title: 'Início', key: 'start_date' },
  { title: 'Fim', key: 'end_date' },
  { title: 'Status', key: 'status' },
  { title: 'Ações', key: 'actions', sortable: false, align: 'center', width: '170' },
])
const loading = ref(false)
const search = ref('')

const getStatusColor = (status: string) => {
  switch (status) {
    case 'Ativo': return 'green'
    case 'Vencendo': return 'orange'
    case 'Encerrado': return 'red'
    default: return 'grey'
  }
}

const showDeleteConfirmation = (item: ContractType) => {
  console.log(item)
  itemToDelete.value = item
  confirmDelete.value = true
}

const deleteContract = () => {
  if (itemToDelete.value) {
    const index = contractStore.contracts.findIndex(c => c.id === itemToDelete.value?.id)
    if (index !== -1) {
      contractStore.contracts.splice(index, 1)
    }
    confirmDelete.value = false
    modal.title = 'Sucesso!'
    modal.message = 'Contrato excluído com sucesso!'
    modal.type = 'success'
    modal.show = true
    // Redireciona para o dashboard após a exclusão
    setTimeout(() => {
      modal.show = false
      router.push('/')
    }, 2000)
  }
}

const loadItems = (options) => {
  // Simula a lógica de carregamento de dados com base nas opções da tabela
  // (pagina, itens por pagina, etc.)
  console.log('Tabela atualizada com as opções:', options)
}
</script>

<style scoped>
.v-card-title {
  display: flex;
  align-items: center;
}
</style>
