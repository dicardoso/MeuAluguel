<template>
  <v-dialog
    v-model="dialog"
    max-width="600"
    persistent
  >
    <v-card rounded="xl">
      <v-card-title class="text-h5">
        Renovar Contrato
      </v-card-title>
      <v-divider />
      <v-card-text>
        <v-row>
          <v-col
            cols="12"
            class="mb-4"
          >
            <p class="text-justify">
              Os campos abaixo permitem atualizar as informações do contrato.
              O status do contrato será atualizado para "Ativo".
            </p>
          </v-col>
        </v-row>
        <v-form @submit.prevent="renewContract">
          <v-row>
            <v-col>
              <v-text-field
                :model-value="props.contrato.renterName.name"
                label="Inquilino"
                disabled
              />
            </v-col>
          </v-row>
          <v-row dense>
            <v-col
              cols="12"
              sm="6"
            >
              <v-text-field
                v-model="form.start_date"
                label="Nova Data de Início"
                type="date"
                :min="new Date().toISOString().split('T')[0]"
                required
              />
            </v-col>
            <v-col
              cols="12"
              sm="6"
            >
              <v-text-field
                v-model="form.end_date"
                label="Nova Data de Fim"
                type="date"
                :min="new Date().toISOString().split('T')[0]"
                required
              />
            </v-col>
            <v-col
              cols="12"
              sm="6"
            >
              <v-text-field
                v-model="form.monthlyRent"
                label="Novo Valor do Aluguel"
                type="number"
                step="0.01"
                min="1"
                prefix="R$"
              />
            </v-col>
            <v-col
              cols="12"
              sm="6"
            >
              <v-text-field
                v-model="form.dueDate"
                label="Novo Dia de Vencimento"
                type="number"
                min="1"
                max="31"
                required
                :rules="[rules.minMax(1, 31)]"
              />
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
      <v-divider />
      <v-card-actions class="justify-end">
        <v-btn
          color="grey-darken-1"
          @click="close"
        >
          Cancelar
        </v-btn>
        <v-btn
          color="primary"
          @click="renewContract"
        >
          Renovar
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup lang="ts">
const emit = defineEmits(['update:modelValue', 'renewed'])
const props = defineProps({
  modelValue: {
    type: Boolean,
    required: true,
  },
  contrato: {
    type: Object,
    required: true,
  },
})
const { rules } = useValidationRules()
const dialog = computed({
  get: () => props.modelValue,
  set: value => emit('update:modelValue', value),
})

const form = reactive({
  start_date: '',
  end_date: '',
  monthlyRent: null,
  dueDate: null,
})

watchEffect(() => {
  if (props.contrato) {
    form.start_date = props.contrato.start_date
    form.end_date = props.contrato.end_date
    form.monthlyRent = props.contrato.monthlyRent
    form.dueDate = props.contrato.dueDate
    console.log('Contrato para renovação:', props.contrato)
  }
})

const close = () => {
  dialog.value = false
}

const renewContract = () => {
  if (!form.start_date || !form.end_date || !form.monthlyRent || !form.dueDate) {
    alert('Por favor, preencha todos os campos.')
    return
  }

  console.log('Renovando contrato com os dados:', { ...props.contrato, ...form, status: 'Ativo' })

  emit('renewed', props.contrato)
  close()
}
</script>
