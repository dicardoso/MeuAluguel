<template>
    <h1>Lista de Usuários</h1>
    <v-data-table
        v-model:sort-by="sortBy"
        :headers="headers"
        :items="users"
        item-value="id"
        class="elevation-1"
    >
        <template #[`item.registry`]="{ item }">
            <span> {{ applyMask(item.registry, '###.###.###-##') }} </span>
        </template>
        <template #[`item.is_active`]="{ item }">
            <v-chip
                :color="item.is_active ? 'green' : 'red'"
                dark
            >
                {{ item.is_active ? 'Ativo' : 'Inativo' }}
            </v-chip>
        </template>
        <template #[`item.actions`]="{ item }">
            <utils-tooltip>
                <template #button>
                    <v-btn density="comfortable" variant="text" icon="mdi-pencil-outline" @click="openDialog(item)"></v-btn>
                </template>
                <template #text>
                    <span>Editar</span>
                </template>
            </utils-tooltip>
        </template>
    </v-data-table>
</template>
  
<script setup>
import { useUserService } from '@/services/users'
const { getUser } = useUserService()
const users = ref([]);
const sortBy = ref([{ key: 'id', order: 'asc' }])
const headers = [
    { title: 'ID', value: 'id', sortable: true },
    { title: 'Nome', value: 'name', sortable: true },
    { title: 'Registro', value: 'registry' },
    { title: 'Email', value: 'email' },
    { title: 'Telefone', value: 'phone' },
    { title: 'Endereço', value: 'address' },
    { title: 'Perfil', value: 'profile.name', sortable: true },
    { title: 'Status', value: 'is_active', sortable: true },
    { title: 'Ações', value: 'actions' }
];

function initialize() {
    getUser({sort: 'id'}).then((data) => {
        console.log(data)
        users.value = data
    })
}
function openDialog(item) {
    console.log(item)
}
initialize()
</script>
  