import { ref } from 'vue'

export default function useValidationRules() {
  const rules = ref({
    required: (value: string) => !!value || 'Campo obrigatório',
  })

  return {
    rules,
  }
}
