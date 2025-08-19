<template>
  <v-app>
    <v-navigation-drawer v-model="drawer" app persistent floating expand-on-hover permanent class="px-2">
      <template #prepend>
        <div class="mt-2 d-flex align-center">
          <figure>
            <img src="@/assets/logo.png" class="w-100" alt="logo" />
          </figure>
        </div>
        <v-divider class="mx-2 mb-1" />
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in menuItems" :key="index" :prepend-icon="item.icon" :to="item.to"
          :disabled="item.disable" class="ma-1 text-white" rounded="xl">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
      <v-divider class="mx-2 mb-1" />
      <template #append>
        <v-container class="px-1">
          <v-card rounded="pill" class="d-flex justify-space-between w-100" @click="() => { }">
            <v-avatar size="52" class="d-flex align-center border-lg" :color="currentUser.color">
              <v-img v-if="currentUser.avatar" alt="Avatar" :src="currentUser.avatar"></v-img>
              <span v-else class="font-weight-medium text-h5">
                {{ currentUser.name.charAt(0) }}
              </span>
            </v-avatar>
            <div class="d-flex flex-column ml-3 py-1">
              <span class="font-weight-bold">{{ currentUser.name }}</span>
              <span class="text-caption">{{ currentUser.role }}</span>
            </div>
            <v-card-actions>
              <v-btn density="comfortable" variant="tonal" icon="mdi-theme-light-dark" @click="toggleTheme"></v-btn>
            </v-card-actions>
          </v-card>
        </v-container>
        <v-divider class="mx-2 mb-1" />
        <v-list>
          <v-list-item v-for="(item, index) in footerMenuItems" :key="index" :prepend-icon="item.icon" :to="item.to"
            :disabled="item.disable" class="text-white" rounded="xl">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </template>
    </v-navigation-drawer>
    <v-main>
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue'
import { useTheme } from 'vuetify'

const theme = useTheme()

const drawer = ref(true)

const menuItems = [
  { title: 'Dashboard', icon: 'mdi-view-dashboard-outline', to: '/dashboard', disable: false },
  { title: 'Contratos', icon: 'mdi-file-document-outline', to: '/contratos', disable: false },
  { title: 'Propriedades', icon: 'mdi-office-building-marker-outline', to: '/propriedades', disable: false },
  { title: 'Pessoas', icon: 'mdi-account-group-outline', to: '/pessoas', disable: false },
]
const footerMenuItems = [
  { title: 'Configuração', icon: 'mdi-tune', to: '/configurar', disable: true },
  { title: 'Sair', icon: 'mdi-logout', to: '/logout', disable: true },
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
