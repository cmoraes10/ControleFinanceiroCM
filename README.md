# ControleFinanceiroCM

A Java CLI personal finance tracker. You can record income and expenses, check the current balance, and pull a summary for any given month. All data lives in memory for the duration of the session.

## Structure

```
src/
  FinanceiroApp.java   menu loop and all financial operations
  Transacao.java       transaction record with type, description, amount, and month
```

## Run

Compile from the `src` directory and run `FinanceiroApp`:

```sh
javac -d out src/FinanceiroApp.java src/Transacao.java
java -cp out FinanceiroApp
```

## License

MIT.
