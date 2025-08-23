<template>
  <v-card class="mt-6">
      <v-card-title>
        <span class="text-h6">Contratos</span>
        <v-spacer />
        <v-btn color="primary" prepend-icon="mdi-plus">Novo Contrato</v-btn>
      </v-card-title>

      <v-data-table
        :headers="[
          { title: 'Inquilino', key: 'inquilino' },
          { title: 'Imóvel', key: 'imovel' },
          { title: 'Início', key: 'inicio' },
          { title: 'Fim', key: 'fim' },
          { title: 'Status', key: 'status' },
          { title: 'Ações', key: 'actions', sortable: false, align: 'center', width: '170' },
        ]"
        :items="contratos"
      >
        <template #item.status="{ item }">
          <v-chip
            :color="statusColor(item.status)"
            dark
            small
          >
            {{ item.status }}
          </v-chip>
        </template>

        <template #item.actions="{ item }">
          <v-btn class="mx-1" variant="outlined" icon density="comfortable" color="orange">
            <v-icon variant="text">mdi-pencil</v-icon>
            <v-tooltip
              activator="parent"
              location="bottom"
            >
              Editar
            </v-tooltip>
          </v-btn>
          <v-btn class="mx-1" variant="outlined" density="comfortable" color="blue" icon="mdi-autorenew">
            <v-icon variant="text">mdi-autorenew</v-icon>
            <v-tooltip
              content-class="vinhozinho"
              activator="parent"
              location="bottom"
            >
              Renovar
            </v-tooltip>
          </v-btn>
          <v-btn class="mx-1" variant="outlined" density="comfortable" color="red" icon="mdi-close">
            <v-icon variant="text">mdi-close</v-icon>
            <v-tooltip
              activator="parent"
              location="bottom"
            >
              Cancelar
            </v-tooltip>
          </v-btn>
        </template>
      </v-data-table>
    </v-card>
</template>

<script setup lang="ts">

const contratos = ref([
  {
    inquilino: "João Silva",
    imovel: "Apto, 2001",
    inicio: "01/09/2023",
    fim: "31/09/2024",
    status: "Ativo",
  },
  {
    inquilino: "Maria Souza",
    imovel: "Casa",
    inicio: "15/03/2022",
    fim: "14/09/2023",
    status: "Encerrado",
  },
  {
    inquilino: "Carlos Lima",
    imovel: "Office",
    inicio: "20/11/2023",
    fim: "19/11/2024",
    status: "Vencendo",
  },
]);
function statusColor(status: string): string {
  if (status === "Vencendo") return "orange";
  return status === "Ativo" ? "green" : "red";
}
</script>

<style scoped>
.v-card-title {
  display: flex;
  align-items: center;
}
</style>
