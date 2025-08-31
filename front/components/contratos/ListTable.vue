<template>
  <v-card
    class="py-4 px-3 ma-2 w-100"
    rounded="xl"
  >
    <v-card-title class="d-flex align-center justify-space-between">
      Contratos
      <v-btn
        :to="{ path: '#' }"
        color="primary"
        prepend-icon="mdi-plus"
        rounded="xl"
        @click="openDialog()"
      >
        Novo Contrato
      </v-btn>
    </v-card-title>
    <v-data-table
      v-model:sort-by="sortBy"
      :headers="headers"
      :items="contracts"
      :loading="loading"
      item-value="id"
    >
      <template #[`item.property`]="{ item }">
        {{ `${item.property?.address} - ${item.property?.complement}` || 'N/A' }}
      </template>
      <template #[`item.value`]="{ item }">
        {{ `R$ ${formatCurrency(item.value)}` }}
      </template>
      <template #[`item.end_date`]="{ item }">
        {{ data.format(item.end_date, 'DD/MM/YYYY') }}
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
        <contratos-action-buttons
          :item="item"
        />
      </template>
    </v-data-table>
    <contratos-edit-dialog
      :dialog="dialog"
      :item="editItem"
      @close-dialog="dialog = false"
      @reload-table="initialize()"
    />
  </v-card>
</template>

<script setup>
import { useDate } from 'vuetify'
import { useContractService } from '@/services/contracts'

const emit = defineEmits(['open-dialog', 'table-loaded'])
const listProps = defineProps({
  reloadTable: {
    type: Boolean,
    default: false,
  },
})

const { getContract } = useContractService()
const data = useDate()
const contracts = ref([])
const editItem = ref({})
const loading = ref(false)
const dialog = ref(false)
const sortBy = ref([{ key: 'id', order: 'asc' }])
const headers = [
  { title: 'ID', value: 'id', sortable: true },
  { title: 'Inquilino', value: 'renterName.name' },
  { title: 'Endereço', value: 'property', sortable: true },
  { title: 'Vencimento', value: 'end_date' },
  { title: 'Valor', value: 'value' },
  { title: 'Status', value: 'is_active', sortable: true },
  { title: 'Ações', value: 'actions', align: 'center', sortable: false, width: '180' },
]

function initialize() {
  loading.value = true
  getContract({ sort: 'id' }).then((data) => {
    contracts.value = data
    emit('table-loaded')
  }).finally(() => {
    loading.value = false
  })
}
watch(
  () => listProps.reloadTable,
  (value) => {
    if (value) {
      initialize()
    }
  },
)
function openDialog(item = {}) {
  dialog.value = true
  editItem.value = item
}
initialize()
</script>
