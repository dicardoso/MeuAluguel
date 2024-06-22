import vuetify, { transformAssetUrls } from 'vite-plugin-vuetify'
export default defineNuxtConfig({
  build: {
    transpile: ['vuetify'],
  },
  devtools: { enabled: true },
  modules: [
    '@pinia/nuxt',
  ],
  plugins: ['@/plugins/vuetify'],
  css: ['vuetify/styles', '@/assets/styles/main.scss'],
})
