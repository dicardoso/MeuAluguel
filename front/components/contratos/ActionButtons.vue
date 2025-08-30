<template>
  <div class="d-flex">
    <v-btn
      class="mx-1"
      variant="outlined"
      icon
      density="comfortable"
      size="small"
      color="orange"
      @click="generatePdf"
    >
      <v-icon variant="text">mdi-file-pdf-box</v-icon>
      <v-tooltip activator="parent" location="bottom">Gerar PDF</v-tooltip>
    </v-btn>

    <v-btn
      class="mx-1"
      variant="outlined"
      icon
      density="comfortable"
      size="small"
      color="orange"
      @click="changeContract"
    >
      <v-icon variant="text">mdi-pencil</v-icon>
      <v-tooltip activator="parent" location="bottom">Editar</v-tooltip>
    </v-btn>

    <v-btn
      class="mx-1"
      variant="outlined"
      density="comfortable"
      size="small"
      color="blue"
      icon="mdi-autorenew"
      @click="openReniewDialog"
    >
      <v-icon variant="text">mdi-autorenew</v-icon>
      <v-tooltip activator="parent" location="bottom">Renovar</v-tooltip>
    </v-btn>

    <v-btn
      class="mx-1"
      variant="outlined"
      density="comfortable"
      size="small"
      color="red"
      icon="mdi-close"
      @click="cancelContract"
    >
      <v-icon variant="text">mdi-close</v-icon>
      <v-tooltip activator="parent" location="bottom">Cancelar</v-tooltip>
    </v-btn>
    <contratos-renew-dialog
      :dialog="dialogRenew"
      :contrato="item"
      @close-dialog="dialogRenew = false"
    />
  </div>
</template>

<script setup lang="ts">
const props = defineProps({
    item: {
        type: Object,
        required: true
    }
})

const dialogRenew = ref(false)

function openReniewDialog() {
  dialogRenew.value = true
}

function generatePdf() {
  console.log("📄 Gerar PDF:", props.item.id)
}

function changeContract() {
  console.log("✏️ Editar contrato:", props.item.id)
}

function cancelContract() {
  console.log("❌ Cancelar contrato:", props.item.id)
}
</script>
