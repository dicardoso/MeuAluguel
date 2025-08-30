<template>
  <v-row
    dense
    class="mb-6"
  >
    <v-col
      cols="12" sm="6" md="3"
    >
      <v-card
        id="1" class="pa-4 text-white text-center" rounded="xl" color="#5cb85c"
      >
        <v-icon
          size="48"
          class="mb-2"
        >
          mdi-file-document-multiple
        </v-icon>
        <div class="text-h4 font-weight-bold">
          35
        </div>
        <div class="text-subtitle-1">
          Contratos Ativos
        </div>
      </v-card>
    </v-col>
    <v-col
      cols="12"
      sm="6"
      md="3"
    >
      <v-card
        class="pa-4 text-white text-center"
        rounded="xl"
        color="#f0ad4e"
      >
        <v-icon
          size="48"
          class="mb-2"
        >
          mdi-calendar-alert
        </v-icon>
        <div class="text-h4 font-weight-bold">
          5
        </div>
        <div class="text-subtitle-1">
          Contratos Vencendo
        </div>
      </v-card>
    </v-col>
    <v-col
      cols="12"
      sm="6"
      md="3"
    >
      <v-card
        class="pa-4 text-white text-center"
        rounded="xl"
        color="#1c75bc"
      >
        <v-icon
          size="48"
          class="mb-2"
        >
          mdi-account-group
        </v-icon>
        <div class="text-h4 font-weight-bold">
          50
        </div>
        <div class="text-subtitle-1">
          Inquilinos Cadastrados
        </div>
      </v-card>
    </v-col>
    <v-col
      cols="12"
      sm="6"
      md="3"
    >
      <v-card
        class="pa-4 text-white text-center"
        rounded="xl"
        color="#1c75bc"
      >
        <v-icon
          size="48"
          class="mb-2"
        >
          mdi-home-city
        </v-icon>
        <div class="text-h4 font-weight-bold">
          12
        </div>
        <div class="text-subtitle-1">
          Total de Imóveis
        </div>
      </v-card>
    </v-col>
  </v-row>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const stats = [
  { title: 'Contratos Ativos', value: 35, icon: 'mdi-file-document-check', color: 'green' },
  { title: 'Contratos Vencendo', value: 5, icon: 'mdi-calendar-alert', color: 'orange' },
  { title: 'Inquilinos Cadastrados', value: 50, icon: 'mdi-account-group', color: '' },
  { title: 'Total de Imóveis', value: 12, icon: 'mdi-home-city', color: 'blue' },
]
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
