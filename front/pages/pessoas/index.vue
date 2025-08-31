<template>
  <v-container fluid>
    <v-row>
      <pessoas-list-table
        :reload-table="reloadTable"
        @table-loaded="reloadTable = false"
        @open-dialog="openDialog"
      />
    </v-row>
    <pessoas-edit-dialog
      :dialog="dialog"
      :item="editItem"
      @close-dialog="dialog = false"
      @reload-table="reloadTable = true"
    />
  </v-container>
</template>

<script setup>
const dialog = ref(false)
const reloadTable = ref(false)
const editItem = ref({})

function openDialog(item = {}) {
  dialog.value = true
  editItem.value = item
}
</script>
