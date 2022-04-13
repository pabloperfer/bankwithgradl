import org.testng.Assert;
import org.testng.annotations.Test;

/** This class test that the assets are correctly added and summed */
public class TransactionsAddAssetsTest {

  @Test
  public void TransactionsAddAssetsTest_addandsumcorrectly() {

    Transaction newtransaction1 =
        new Transaction("BTC-USD", 1625438499L, "buy", 0.0445881D, 2000.0D);
    Transaction newtransaction2 =
        new Transaction("BTC-USD", 1625438499L, "buy", 0.0945881D, 2000.0D);

    Transactions.addTransaction(newtransaction1);
    Transactions.addTransaction(newtransaction2);

    for (Asset as : Assets.assets) {
      if (as.getAssetSymbol().equals("BTC-USD")) {
        double qty = as.getAssetGty();
        Assert.assertEquals(qty, 0.1391762);
      } else {
        System.out.println("not found");
      }
    }
  }
}
