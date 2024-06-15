# Aplicação para Calculo de Propostas de Seguros

Esta api funciona para gerar propostas personalizadas de acordo com o perfil do cliente (Valor do veiculo, idade e localidade).

## Funcionalidades

- O cliente informa os dados de seu carro, e os seus dados pessoais, e a aplicação gera recomendações, entre básico, parcial e total com valor variavel, de acordo com o valor do carro.

## Regras de Negócio

- Seguro Básico.  Valor: 2% do valor do veículo 
- Seguro Parcial. Valor: 3% do valor do veículo
- Seguro Total.   Valor: 4% do valor do veículo

|                              | Seguro Básico | Seguro Parcial | Seguro Total |
|------------------------------|---------------|:--------------:|--------------|
| Veículo <= 70.000            | Sim           |   Sim\*\*\*    | Não          |
| Veículo > 70.000 e < 100.000 | Sim           |    Sim\*\*     | Não          |
| Veículo => 100.000           | Sim           |     Sim\*      | Sim          |

- \* Clientes com menos de 30 anos
- \*\* Clientes que residem em SP
- \*\*\* Clientes com menos de 30 anos que residem em SP

## Utilização

A aplicação deve receber como entrada essas informações:

##### input

```json
{
  "customer": {
    "name": "João",
    "cpf": "123.456.789-10",
    "age": 29,
    "location": "BH",
    "valor_veiculo": 70000
  }
}

E a aplicação irá responder essas informações:

##### output

```json
{
  "customer": {
    "name": "João",
    "insurances": [
      {
            "type": "basic",
            "cost": 1400
        },
        {
            "type": "parcial",
            "cost": 2100
        }
    ]
  }
}
```