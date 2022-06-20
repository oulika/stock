package vip.linhs.stock.api.request;

import java.util.List;

public class SubmitBatTradeV2Request extends BaseTradeListRequest {

    private List<SubmitData> list;

    public SubmitBatTradeV2Request(int userId) {
        super(userId);
    }

    public static class SubmitData {

        private String StockCode;
        private String StockName;
        private String Price;
        private int Amount;
        private String TradeType;
        private String Market;
        private String Xyjylx = "6";

        public String getStockCode() {
            return StockCode;
        }

        public void setStockCode(String stockCode) {
            StockCode = stockCode;
        }

        public String getStockName() {
            return StockName;
        }

        public void setStockName(String stockName) {
            StockName = stockName;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String price) {
            Price = price;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        public String getTradeType() {
            return TradeType;
        }

        public void setTradeType(String tradeType) {
            TradeType = tradeType;
        }

        public String getMarket() {
            return Market;
        }

        public void setMarket(String market) {
            Market = market;
        }

        public String getXyjylx() {
            return Xyjylx;
        }

        public void setXyjylx(String xyjylx) {
            Xyjylx = xyjylx;
        }

    }

    @Override
    public List<SubmitData> getList() {
        return list;
    }

    public void setList(List<SubmitData> list) {
        this.list = list;
    }

    @Override
    public String getMethod() {
        return BaseTradeRequest.TradeRequestMethod.CrSubmitBatTradeV2.value();
    }

}
