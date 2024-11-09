import { Mask } from 'maska'

export function formatCurrency(value: bigint | number = 0) {
  return new Intl.NumberFormat('pt-BR', {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
  }).format(value)
}

export function applyMask(value: string, pattern: string) {
  const maskInstance = new Mask({ mask: pattern })
  return maskInstance.masked(value)
}
