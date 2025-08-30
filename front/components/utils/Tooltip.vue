<template>
  <v-tooltip
    :open-on-hover="true"
    activator="parent"
    :location="location"
  >
    <template #activator="{ props }">
      <div
        class="d-inline"
        v-bind="props"
      >
        <slot name="button" />
      </div>
    </template>
    <slot name="text" />
  </v-tooltip>
</template>

<script setup>
import { defineProps } from 'vue'

const props = defineProps({
  location: {
    type: String,
    default: 'bottom',
    validator: value => ['top', 'bottom', 'left', 'right'].includes(value),
  },
})
</script>

  <style scoped>
  span {
    color: inherit;
  }
  </style>
