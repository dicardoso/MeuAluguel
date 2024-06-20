// Vuetify
import 'vuetify/styles'
import { ThemeDefinition, createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

const dark: ThemeDefinition = {
  dark: true,
  colors: {
    primary: '#133ed4',
    accent: '#67617f',
    secondary: '#4f4f4f',
    info: '#0059FF',
    'is-active': '#67617f',
    background: '#202020',
    bgCard: '#373737',
    bgNavigation: '#000000',
    errorSnackbar: '#EB5757',
    infoSnackbar: '#6FB1C9',
  },
}
const light: ThemeDefinition = {
  dark: false,
  colors: {
    primary: '#133ed4',
    secondary: '#dfdfe1',
    accent: '#00a6ff',
    info: '#0059FF',
    'is-active': '#0059FF',
    background: '#f2f2f5',
    bgCard: '#FCFCFC',
    bgNavigation: '#133ed4',
    errorSnackbar: '#EB5757',
    infoSnackbar: '#6FB1C9',
  },
}
export default defineNuxtPlugin((nuxtApp) => {
  const vuetify = createVuetify({
    ssr: true,
    components,
    directives,
    theme: {
      defaultTheme: 'light',
      themes: {
        light,
        dark,
      },
    },
  })

  nuxtApp.vueApp.use(vuetify)
})
