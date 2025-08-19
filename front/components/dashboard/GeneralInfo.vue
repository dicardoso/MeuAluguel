<template>
    <v-row>
      <v-col cols="12" sm="6" md="3" v-for="(item, i) in stats" :key="i">
        <v-card class="pa-4 text-center d-flex align-center justify-space-around" :color="item.color" elevation="2">
          <v-icon size="50">{{ item.icon }}</v-icon>
          <div class="">
            <p class="text-subtitle-1">{{ item.title }}</p>
            <h3 class="mt-2 font-weight-black">{{ item.value }}</h3>
          </div>
        </v-card>
      </v-col>
    </v-row>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const stats = [
  { title: "Contratos Ativos", value: 35, icon: "mdi-file-document-check", color: 'green' },
  { title: "Contratos Vencendo", value: 5, icon: "mdi-calendar-alert", color: 'orange' },
  { title: "Inquilinos Cadastrados", value: 50, icon: "mdi-account-group", color: '' },
  { title: "Total de Imóveis", value: 12, icon: "mdi-home-city", color: 'blue' }, 
];
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
