export default defineNuxtConfig({

  modules: [
    '@pinia/nuxt',
    '@nuxt/eslint',
  ],
  plugins: ['@/plugins/vuetify', '@/plugins/maska'],
  ssr: false,
  devtools: { enabled: true },
  css: ['vuetify/styles', '@/assets/styles/main.scss'],
  runtimeConfig: {
    public: {
      baseUrl: process.env.API_BASE || 'http://localhost:8080',
    },
  },
  build: {
    transpile: ['vuetify'],
  },
})
