package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.Lotto;

public class LottoDraw {

    private final int lottoTicketsNumber;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoDraw(int lottoTicketsNumber) {
        this.lottoTicketsNumber = lottoTicketsNumber;
    }

    public void configureNumbers() {
        for (int i = 0; i < this.lottoTicketsNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableNumbers = new ArrayList<>(numbers);
            mutableNumbers.sort(Comparator.naturalOrder());
            this.lottos.add(new Lotto(mutableNumbers));
        }
    }

    public void printPurchaseHistory() {
        System.out.print("\n" + this.lottoTicketsNumber + "개를 구매했습니다.\n");
        this.lottos.forEach(Lotto::printNumbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
