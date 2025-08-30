<template>
  <v-container>
    <v-card>
      <v-card-title>Messages & Announcements</v-card-title>
      <v-list>
        <v-list-item
          v-for="(message, index) in messages"
          :key="index"
        >
          <v-list-item-content>
            <v-list-item-title>{{ message.title }}</v-list-item-title>
            <v-list-item-subtitle>{{ message.content }}</v-list-item-subtitle>
          </v-list-item-content>
          <v-list-item-action>
            <v-btn icon>
              <v-icon>mdi-reply</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
      </v-list>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const messages = ref([
  { title: 'System Update', content: 'The system will be down for maintenance at midnight.' },
  { title: 'New Feature', content: 'We have released a new feature to help you manage contracts more effectively.' },
])
</script>
