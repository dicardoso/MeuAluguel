import vuetify, { transformAssetUrls } from 'vite-plugin-vuetify'
export default defineNuxtConfig({
  runtimeConfig: {
    public: {
      baseUrl: process.env.API_BASE || "http://localhost:8080",
    },
  },
  build: {
    transpile: ['vuetify'],
  },
  ssr: false,
  devtools: { enabled: true },
  modules: [
    '@pinia/nuxt',
    '@nuxt/eslint',
  ],
  plugins: ['@/plugins/vuetify', '@/plugins/maska'],
  css: ['vuetify/styles', '@/assets/styles/main.scss'],
})
