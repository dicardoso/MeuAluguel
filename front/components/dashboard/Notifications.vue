<template>
  <v-container>
    <v-card>
      <v-card-title>Notifications</v-card-title>
      <v-list>
        <v-list-item
          v-for="(notification, index) in notifications"
          :key="index"
        >
          <v-list-item-content>
            <v-list-item-title>{{ notification.title }}</v-list-item-title>
            <v-list-item-subtitle>{{ notification.description }}</v-list-item-subtitle>
          </v-list-item-content>
          <v-list-item-action>
            <v-btn icon>
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
      </v-list>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const notifications = ref([
  { title: 'New Contract Created', description: 'A new contract has been created by User A' },
  { title: 'Pending Issue', description: 'There is a pending issue that needs your attention' },
])
</script>
