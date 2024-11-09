<template>
  <v-container>
    <v-card>
      <v-card-title>Upcoming Events</v-card-title>
      <v-card-text>
        <v-sheet height="600">
        <v-calendar
          ref="calendar"
          v-model="today"
          :events="events"
          color="primary"
          type="month"
        ></v-calendar>
      </v-sheet>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const today = ref(new Date().toISOString().substr(0, 10))
const events = ref([
  { name: 'Contract Signing', start: '2024-07-01', end: '2024-07-01' },
  { name: 'Project Deadline', start: '2024-07-15', end: '2024-07-15' },
])
const type = 'month'
const types = ['month', 'week', 'day']
const weekday = [0, 1, 2, 3, 4, 5, 6]
const value = [new Date()]
</script>
