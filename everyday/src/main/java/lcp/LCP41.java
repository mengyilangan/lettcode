package lcp;

/**
 * https://leetcode.cn/problems/fHi6rV/
 * LCP 41. 黑白翻转棋
 * 在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，空余位置记作 "."。
 * 当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
 * 力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 chessboard。
 * 若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。
 * <p>
 * 注意：
 * <p>
 * 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
 * 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
 * 提示：
 * <p>
 * 1 <= chessboard.length, chessboard[i].length <= 8
 * chessboard[i] 仅包含 "."、"O" 和 "X"
 */
public class LCP41 {
    public int flipChess(String[] chessboard) {
        if (chessboard.length <= 2) {
            return horizontal(chessboard);
        } else if (chessboard[0].length() <= 2) {
            return vertical(chessboard);
        }
        return 0;
    }

    /**
     * 横着来
     *
     * @param chessboard
     * @return
     */
    public int horizontal(String[] chessboard) {
        for (String c : chessboard) {

        }
        return 0;
    }

    /**
     * 竖着来
     *
     * @return
     */
    public int vertical(String[] chessboard) {
        return 0;
    }
}
