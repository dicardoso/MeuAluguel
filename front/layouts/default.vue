<template>
  <v-app>
    <!-- Menu lateral fixo -->
    <v-navigation-drawer
      v-model="drawer"
      app
      :permanent="$vuetify.display.mdAndUp"
      dark
      color="#2c3e50"
    >
      <v-list-item class="pa-4 text-center">
        <v-list-item-title class="text-h6 font-weight-bold">
          Meu Aluguel
        </v-list-item-title>
      </v-list-item>
      <v-divider />
      <v-list nav>
        <v-list-item
          v-for="(item, index) in menuItems"
          :key="index"
          :prepend-icon="item.icon"
          :to="item.to"
          :disabled="item.disable"
          class="ma-1 text-white"
          rounded="xl"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
      <template #append>
        <v-divider />
        <v-list nav>
          <v-list-item
            v-for="(item, index) in footerMenuItems"
            :key="index"
            :prepend-icon="item.icon"
            :to="item.to"
            :disabled="item.disable"
            class="ma-1 text-white"
            rounded="xl"
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
        <div class="pa-4 text-center">
          <v-avatar
            size="48"
            class="mb-2"
          >
            <v-img src="https://placehold.co/48x48/CCCCCC/333333?text=MF" />
          </v-avatar>
          <div class="text-subtitle-1 text-white">
            Maria de Fátima
          </div>
          <div class="text-caption text-grey-lighten-2">
            Administrador
          </div>
        </div>
      </template>
    </v-navigation-drawer>
    <v-app-bar
      app
      dark
      color="#2c3e50"
    >
      <v-app-bar-nav-icon
        class="d-md-none"
        @click.stop="drawer = !drawer"
      />
      <v-toolbar-title v-if="$vuetify.display.mdAndDown">
        Meu Aluguel
      </v-toolbar-title>
      <v-spacer />
      <!-- Adicionar um ícone de pnotificações se necessário -->
    </v-app-bar>
    <v-main class="h-100">
      <router-view />
    </v-main>
  </v-app>
</template>

<script setup>
import { useTheme } from 'vuetify'

const theme = useTheme()
const drawer = ref(false)

const menuItems = [
  { title: 'Dashboard', icon: 'mdi-view-dashboard-outline', to: '/dashboard', disable: false },
  { title: 'Contratos', icon: 'mdi-file-document-outline', to: '/contratos', disable: false },
  { title: 'Propriedades', icon: 'mdi-office-building-marker-outline', to: '/propriedades', disable: false },
  { title: 'Pessoas', icon: 'mdi-account-group-outline', to: '/pessoas', disable: false },
]
const footerMenuItems = [
  { title: 'Configuração', icon: 'mdi-cog', to: 'configurar', disable: true },
  { title: 'Sair', icon: 'mdi-logout', to: '#', disable: true },
]
const currentUser = reactive({ name: 'Maria Joana', role: 'Administrador', avatar: 'https://randomuser.me/api/portraits/women/28.jpg', color: '#D95030' })
function toggleTheme() {
  theme.global.name.value = theme.global.current.value.dark ? 'light' : 'dark'
}
</script>

<style>
.v-navigation-drawer {
  background-color: #162e4c;
}

.v-list-item--active {
  background-color: #223958;
}
</style>
