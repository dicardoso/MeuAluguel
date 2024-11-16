<template>
  <v-container fluid>
    <v-row class="justify-space-between mb-2">
      <div>
        <span class="text-h5">Lista de Usuários</span>
      </div>
      <div cols="3" class="align-content-end">
        <v-btn color="primary" prepend-icon="mdi-account-plus-outline" @click="openDialog()">Adicionar Usuário</v-btn>
      </div>
    </v-row>
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
  console.log(item)
  dialog.value = true
  editItem.value = item
}
</script>