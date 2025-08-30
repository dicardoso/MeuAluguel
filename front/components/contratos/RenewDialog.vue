<template>
  <v-dialog
    v-model="open"
    max-width="500"
  >
    <v-card>
      <v-card-title class="text-h6 d-flex align-center justify-space-between">
        <span>Renovar Contrato</span>
        <v-btn
          icon="mdi-close"
          density="comfortable"
          variant="text"
          @click="close()"
        />
      </v-card-title>
      <v-card-text>
        <div class="mb-4">
          Renovar contrato de
          <strong>{{ contrato?.renterName.name }}</strong>
          referente ao imóvel
          <strong>{{ `${contrato?.property.address} - ${contrato?.property.complement}` }}</strong>?
        </div>

        <v-menu
          v-model="menu"
          :close-on-content-click="false"
          transition="scale-transition"
          offset-y
          max-width="290"
          min-width="290"
        >
          <template #activator="{ props }">
            <v-text-field
              v-bind="props"
              v-model="novaDataFim"
              label="Nova Data de Término"
              readonly
              prepend-icon="mdi-calendar"
            />
          </template>

          <v-date-picker
            v-model="novaDataFim"
            color="primary"
            @update:model-value="menu = false"
          />
        </v-menu>
      </v-card-text>

      <v-card-actions>
        <v-spacer />
        <v-btn
          variant="text"
          @click="close"
        >
          Cancelar
        </v-btn>
        <v-btn
          color="primary"
          @click="confirmar"
        >
          Confirmar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue'

const props = defineProps({
  dialog: {
    type: Boolean,
    required: true,
  },
  contrato: {
    type: Object,
    required: false,
  },
})

const emit = defineEmits(['closeDialog', 'confirm'])

const menu = ref(false)
const novaDataFim = ref('')
const open = ref(false)

watch(
  () => props.dialog,
  (val) => {
    open.value = val
    if (val && props.contrato) {
      const hoje = new Date(props.contrato.end_date)
      hoje.setFullYear(hoje.getFullYear() + 1)
      console.log(props.contrato)
      novaDataFim.value = hoje.toISOString().split('T')[0]
    }
  },
)

function close() {
  open.value = false
  emit('closeDialog')
}

function confirmar() {
  console.log('confirm', { ...props.contrato, fim: novaDataFim.value })
  close()
}
</script>
