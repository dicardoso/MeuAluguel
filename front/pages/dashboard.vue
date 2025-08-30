<script setup lang="ts">
import GeneralInfo from '~/components/dashboard/GeneralInfo.vue'
import ListTable from '~/components/dashboard/ListTable.vue'

const stats = [
  { title: 'Total de Imóveis', value: 12, icon: 'mdi-home-city' },
  { title: 'Contratos Ativos', value: 35, icon: 'mdi-file-document-check' },
  { title: 'Inquilinos Cadastrados', value: 50, icon: 'mdi-account-group' },
  { title: 'Contratos Vencendo', value: 5, icon: 'mdi-calendar-alert' },
]
</script>

<template>
  <v-container fluid>
    <general-info />

    <list-table />
  </v-container>
</template>
