<template>
  <v-card class="pa-4" rounded="xl">
    <v-card-title class="d-flex align-center justify-space-between">
        Contratos
        <v-btn 
            :to="{ path: '/new' }" 
            color="secondary" 
            prepend-icon="mdi-plus" 
            rounded="xl"
        >
            Novo Contrato
        </v-btn>
    </v-card-title>
    <v-data-table-server
        v-if="contractStore.contracts.length > 0"
        v-model:items-per-page="itemsPerPage"
        :headers="headers"
        :items="contractStore.contracts"
        :items-length="contractStore.contracts.length"
        :loading="loading"
        :search="search"
        item-value="name"
        @update:options="loadItems"
        class="mt-4"
    >
        <template v-slot:item.status="{ item }">
            <v-chip :color="getStatusColor(item.status)" class="text-capitalize">{{ item.status }}</v-chip>
        </template>
        <template v-slot:item.actions="{ item }">
            <v-btn icon color="blue" size="small" :to="'/contracts/' + item.id" class="mr-2">
                <v-icon>mdi-pencil</v-icon>
            </v-btn>
            <v-btn icon color="orange" size="small" :to="'/contracts/' + item.id" class="mr-2">
                <v-icon>mdi-eye</v-icon>
            </v-btn>
            <v-btn icon color="red" size="small" @click="showDeleteConfirmation(item)">
                <v-icon>mdi-delete</v-icon>
            </v-btn>
        </template>
    </v-data-table-server>
    <div v-else class="text-center text-grey-darken-1 py-10">
        <p>Nenhum contrato encontrado.</p>
    </div>
  </v-card>
</template>

<script setup lang="ts">
import type { ContractType } from '~/types/contracts';

const contractStore = reactive({
            contracts: [
                { id: 1, inquilino: 'João Silva', imovel: 'Apto, 2001', inicio: '2023-01-15', fim: '2024-01-14', monthlyRent: 1500.00, status: 'Ativo' },
                { id: 2, inquilino: 'Maria Souza', imovel: 'Casa', inicio: '2023-03-01', fim: '2023-11-14', monthlyRent: 2200.00, status: 'Encerrado' },
                { id: 3, inquilino: 'Carlos Lima', imovel: 'Office', inicio: '2023-05-20', fim: '2024-05-19', monthlyRent: 1850.00, status: 'Vencendo' },
                { id: 4, inquilino: 'Ana Clara', imovel: 'Loja, 32', inicio: '2024-01-01', fim: '2025-01-01', monthlyRent: 3000.00, status: 'Ativo' },
                { id: 5, inquilino: 'Pedro Martins', imovel: 'Apartamento', inicio: '2023-09-10', fim: '2024-09-09', monthlyRent: 1900.00, status: 'Ativo' },
                { id: 6, inquilino: 'Juliana Costa', imovel: 'Studio', inicio: '2024-03-01', fim: '2025-02-28', monthlyRent: 1200.00, status: 'Vencendo' },
                { id: 7, inquilino: 'Rafael Gomes', imovel: 'Casa de Campo', inicio: '2022-07-01', fim: '2023-06-30', monthlyRent: 2500.00, status: 'Encerrado' },
            ],

            nextId: 8
        });
const modal = reactive({ show: false, title: '', message: '', type: 'info' });
                const confirmDelete = ref(false);
                const itemToDelete = ref<ContractType | null>(null);
                const router = useRouter();
                
                // Configuração da tabela
                const itemsPerPage = ref(10);
                const headers = ref([
          { title: 'Inquilino', key: 'inquilino' },
          { title: 'Imóvel', key: 'imovel' },
          { title: 'Início', key: 'inicio' },
          { title: 'Fim', key: 'fim' },
          { title: 'Status', key: 'status' },
          { title: 'Ações', key: 'actions', sortable: false, align: 'center', width: '170' },
        ]);
                const loading = ref(false);
                const search = ref('');

                const getStatusColor = (status: string) => {
                    switch (status) {
                        case 'Ativo': return 'green';
                        case 'Vencendo': return 'orange';
                        case 'Encerrado': return 'red';
                        default: return 'grey';
                    }
                };
                
                const showDeleteConfirmation = (item: ContractType) => {
                  console.log(item);
                    itemToDelete.value = item;
                    confirmDelete.value = true;
                };

                const deleteContract = () => {
                    if (itemToDelete.value) {
                        const index = contractStore.contracts.findIndex(c => c.id === itemToDelete.value?.id);
                        if (index !== -1) {
                            contractStore.contracts.splice(index, 1);
                        }
                        confirmDelete.value = false;
                        modal.title = 'Sucesso!';
                        modal.message = 'Contrato excluído com sucesso!';
                        modal.type = 'success';
                        modal.show = true;
                        // Redireciona para o dashboard após a exclusão
                        setTimeout(() => {
                            modal.show = false;
                            router.push('/');
                        }, 2000);
                    }
                };

                const loadItems = (options) => {
                    // Simula a lógica de carregamento de dados com base nas opções da tabela
                    // (pagina, itens por pagina, etc.)
                    console.log('Tabela atualizada com as opções:', options);
                };
</script>

<style scoped>
.v-card-title {
  display: flex;
  align-items: center;
}
</style>
