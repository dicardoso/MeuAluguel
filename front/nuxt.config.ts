import vuetify, { transformAssetUrls } from 'vite-plugin-vuetify'
export default defineNuxtConfig({
  runtimeConfig: {
    public: {
      baseUrl: 'http://localhost:8080/api',
    },
  },
  build: {
    transpile: ['vuetify'],
  },
  ssr: false,
  devtools: { enabled: true },
  modules: [
    '@pinia/nuxt',
  ],
  plugins: ['@/plugins/vuetify', '@/plugins/maska'],
  css: ['vuetify/styles', '@/assets/styles/main.scss'],
})
