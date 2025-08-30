import { ref } from 'vue'

export default function useValidationRules() {
  const rules = ref({
    required: (value: string) => !!value || 'Campo obrigatório',
    minMax: (min: number, max: number) => (v: string) =>
      (Number(v) >= min && Number(v) <= max) || `O valor deve estar entre ${min} e ${max}`,
  })

  return {
    rules,
  }
}
