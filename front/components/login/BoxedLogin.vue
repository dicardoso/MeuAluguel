<template>
    <v-container fluid class="pa-3">
        <v-card rounded="xl" elevation="10" class="px-sm-1 px-0 mx-auto index-2" max-width="450">
            <v-card-item class="pa-sm-8">
                <div class="d-flex justify-center mb-5">
                    <Logo />
                </div>
                <div class="text-h4 text-high-emphasis text-center mb-4">Meu Aluguel</div>
                <LoginForm />
                <h6 class="text-subtitle-1 text-grey100 d-flex justify-center align-center mt-3">
                    Novo usuário?
                    <v-btn
                        class="px-2 text-primary text-body-1 font-weight-medium"
                        height="auto"
                        disabled
                        to="/auth/register"
                        variant="plain"
                    >
                        Criar uma conta
                    </v-btn>
                </h6>
            </v-card-item>
        </v-card>
    </v-container>
</template>
<script setup lang="ts">
</script>