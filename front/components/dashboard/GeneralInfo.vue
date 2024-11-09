<template>
  <v-container fluid>
    <v-row>
      <!-- Card 1 -->
      <v-col cols="12" md="4">
        <v-card color="blue-lighten-3" @click="()=>{}">
          <v-card-title>
            <v-icon class="mr-2">mdi-file-document</v-icon>
            Contratos Totais
          </v-card-title>
          <v-card-text class="d-flex justify-end align-center">
            <h3 class="text-h3 font-weight-bold">{{ totalContracts }}</h3>
          </v-card-text>
        </v-card>
      </v-col>

      <!-- Card 2 -->
      <v-col cols="12" md="4">
        <v-card color="green-lighten-3">
          <v-card-title>
            <v-icon class="mr-2">mdi-account</v-icon>
            Usuários Ativos
          </v-card-title>
          <v-card-text class="d-flex justify-end align-center">
            <h3 class="text-h3 font-weight-bold">{{ activeUsers }}</h3>
          </v-card-text>
        </v-card>
      </v-col>

      <!-- Card 3 -->
      <v-col cols="12" md="4">
        <v-card color="yellow-lighten-3">
          <v-card-title>
            <v-icon class="mr-2">mdi-cash-multiple</v-icon>
            Receita
          </v-card-title>
          <v-card-text class="d-flex justify-end align-center">
            <h3 class="text-h3 font-weight-bold">{{ revenue }}</h3>
          </v-card-text>
        </v-card>
      </v-col>

      <!-- Card 4 -->
      <v-col cols="12" md="4">
        <v-card color="red-lighten-3">
          <v-card-title>
            <v-icon class="mr-2" :class="{ 'alert-icon': pendingIssues > 0 }">mdi-alert-circle</v-icon>
            Pendências
          </v-card-title>
          <v-card-text class="d-flex justify-end align-center">
            <h3 class="text-h3 font-weight-bold">{{ pendingIssues }}</h3>
          </v-card-text>
        </v-card>
      </v-col>

      <!-- Card 5 -->
      <v-col cols="12" md="4">
        <v-card color="purple-lighten-4">
          <v-card-title>
            <v-icon class="mr-2">mdi-calendar-check</v-icon>
            Próximos Eventos
          </v-card-title>
          <v-card-text class="d-flex justify-end align-center">
            <h3 class="text-h3 font-weight-bold">{{ upcomingEvents }}</h3>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const totalContracts = ref(120)
const activeUsers = ref(45)
const revenue = ref('$10,000')
const pendingIssues = ref(8)
const upcomingEvents = ref(3)
</script>

<style scoped>
.v-card-title {
  display: flex;
  align-items: center;
}
.alert-icon {
  animation: alert-animation 1s infinite;
}

@keyframes alert-animation {
  0%, 100% { transform: scale(1); }
  50% { transform: scale(1.2); }
}
</style>
