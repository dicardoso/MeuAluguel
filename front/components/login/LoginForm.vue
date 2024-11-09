<template>
    <div class="d-flex align-center text-center mb-6">
        <div class="text-h6 w-100 px-5 font-weight-regular">
            <span class="bg-surface py-3 text-subtitle-1 text-grey-darken-1">Plataforma de Gerênciamento de Contratos</span>
        </div>
    </div>
    <v-form @submit.prevent="onLogin">
        <v-row class="mb-3">
            <v-col cols="12">
                <v-label class="font-weight-medium mb-1">Usuário</v-label>
                <v-text-field variant="outlined" color="primary" :rules="[rules.required]"></v-text-field>
            </v-col>
            <v-col cols="12">
                <v-label class="font-weight-medium mb-1">Senha</v-label>
                <v-text-field 
                    variant="outlined"
                    color="primary"
                    :rules="[rules.required]"
                    :type="showPass ? 'password' : 'text'"
                    :append-inner-icon="showPass ? 'mdi-eye' : 'mdi-eye-off'"
                    @click:append-inner="showPass = !showPass"
                />
            </v-col>
            <v-col cols="12 " class="py-0">
                <div class="d-flex flex-wrap align-center w-100 ">
                    <div class="ml-sm-auto">
                        <RouterLink 
                            to=""
                            class="text-primary text-decoration-none text-body-2 font-weight-medium">
                            Esqueceu a senha?
                        </RouterLink>
                    </div>
                </div>
            </v-col>
            <v-col cols="12" class="mt-6">
                <v-btn
                    size="large"
                    rounded="pill"
                    color="primary"
                    block
                    type="submit"
                    flat
                >
                    Entrar
                </v-btn>
            </v-col>
        </v-row>
    </v-form>
</template>
<script setup lang="ts">
import { ref } from 'vue'
import useValidationRules from '@/composables/useValidationRules'

const { rules } = useValidationRules()
const showPass = ref(true)

function onLogin() {
    navigateTo('/dashboard')
}
</script>