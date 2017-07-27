package RPG.model.traders;

import RPG.model.Characters.Human;

public interface TradersFactory {
    Trader getTrader(Human human);
}
