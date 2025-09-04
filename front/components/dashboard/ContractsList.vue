<template>
  <v-card
    class="px-4 py-0 elevation-0"
    rounded="xl"
  >
    <v-card-title class="d-flex align-center justify-space-between">
      Contratos
      <v-btn
        :to="{ path: '/new' }"
        color="secondary"
        prepend-icon="mdi-plus"
        rounded="xl"
      >
        Novo Contrato
      </v-btn>
    </v-card-title>
    <v-row
      class="mt-4"
      dense
    >
      <v-col
        v-for="contract in contractStore.contracts"
        :key="contract.id"
        cols="12"
        sm="6"
        md="4"
        lg="3"
      >
        <v-card
          rounded="xl"
          variant="outlined"
        >
          <v-card-text>
            <div class="d-flex justify-space-between align-center mb-2">
              <div class="text-h6 font-weight-bold">
                {{ contract.tenantName }}
              </div>
              <v-chip
                :color="getStatusColor(contract.status)"
                class="text-capitalize font-weight-bold"
              >
                {{ contract.status }}
              </v-chip>
            </div>
            <div class="text-body-2 text-grey-darken-1 mb-1">
              <v-icon
                size="small"
                class="mr-1"
              >
                mdi-home-outline
              </v-icon>
              {{ contract.propertyAddress }}
            </div>
            <div class="text-body-2 text-grey-darken-1 mb-1">
              <v-icon
                size="small"
                class="mr-1"
              >
                mdi-calendar-range
              </v-icon>
              {{ formatDate(contract.startDate) }} a {{ formatDate(contract.endDate) }}
            </div>
            <div class="text-body-2 text-grey-darken-1">
              <v-icon
                size="small"
                class="mr-1"
              >
                mdi-cash
              </v-icon>
              R$ {{ contract.monthlyRent.toFixed(2) }}
            </div>
          </v-card-text>
          <v-divider />
          <v-card-actions class="justify-end">
            <contratos-action-buttons />
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col
        v-if="contractStore.contracts.length === 0"
        cols="12"
      >
        <div class="text-center text-grey-darken-1 py-10">
          <p>Nenhum contrato encontrado.</p>
        </div>
      </v-col>
    </v-row>
  </v-card>
</template>

<script setup>
const contractStore = reactive({
  contracts: [
    { id: 1, tenantName: 'João Silva', propertyAddress: 'Apto, 2001', startDate: '2023-01-15', endDate: '2024-01-14', monthlyRent: 1500.00, dueDate: 15, status: 'Ativo' },
    { id: 2, tenantName: 'Maria Souza', propertyAddress: 'Casa', startDate: '2023-03-01', endDate: '2023-11-14', monthlyRent: 2200.00, dueDate: 1, status: 'Encerrado' },
    { id: 3, tenantName: 'Carlos Lima', propertyAddress: 'Office', startDate: '2023-05-20', endDate: '2024-05-19', monthlyRent: 1850.00, dueDate: 20, status: 'Vencendo' },
    { id: 4, tenantName: 'Ana Clara', propertyAddress: 'Loja, 32', startDate: '2024-01-01', endDate: '2025-01-01', monthlyRent: 3000.00, dueDate: 1, status: 'Ativo' },
  ],
  nextId: 8,
})

const getStatusColor = (status) => {
  switch (status) {
    case 'Ativo': return 'green'
    case 'Vencendo': return 'orange'
    case 'Encerrado': return 'red'
    default: return 'grey'
  }
}

const formatDate = (dateString) => {
  if (!dateString) return ''
  const [year, month, day] = dateString.split('-')
  return `${day}/${month}/${year}`
}
</script>
