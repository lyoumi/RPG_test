package RPG.model.traeders;

import RPG.model.Characters.Human;

public interface TradersFactory {
    Trader getTrader(Human human);
}
