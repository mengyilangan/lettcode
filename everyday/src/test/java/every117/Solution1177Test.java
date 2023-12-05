package every117;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution1177Test {

    /**
     * 入：s = "abcda", queries = {{}3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1]]
     * 输出：[true,false,false,true,true]
     * 解释：
     * queries[0] : 子串 = "d"，回文。
     * queries[1] : 子串 = "bc"，不是回文。
     * queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
     * queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
     * queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"
     */
    @Test
    void canMakePaliQueries() {
        Solution1177 solution = new Solution1177();
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> res = solution.canMakePaliQueries(s, queries);
        System.out.println(res);
    }

    /**
     * 入：s = "abcda", queries = {{}}1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{}1,1,1]]
     */
    @Test
    void canMakePaliQueriesCase1() {
        Solution1177 solution = new Solution1177();
        //可以重新排列
        String s = "hunu";
        //unu(hn)
        //5个数是2对
        int[][] queries = {{1, 1, 1}, {2, 3, 0}, {3, 3, 1}, {0, 3, 2}, {1, 3, 3}, {2, 3, 1}, {3, 3, 1}, {0, 3, 0}, {1, 1, 1}, {2, 3, 0}, {3, 3, 1}, {0, 3, 1}, {1, 1, 1}};
        queries = new int[][]{{0, 3, 1}};

        List<Boolean> res = solution.canMakePaliQueries(s, queries);
        System.out.println(res);
    }

    @Test
    void case2() {
        Solution1177 solution = new Solution1177();
        String s = "lybypsnwvozshezupkrubmrapgbsbininmjmjkbkjkvoxcpqrsvwfshmtulqrypyhofubmnylkrapqhgxgdofcvmrylqpejqbalahwryrkzavgdmdgtqpgpmjghexybyrgzczyhafcdqbgncrcbihkdmhunuzqrkzsnidwbunszulspmhwpazoxijwbqpapmretkborsrurgtinansnupotstmnkfcfavaxglyzebsbuxmtcfmtodclszghejevmhcvshclydqrulwbyhajgtargjctqvijshexyjcjcrepyzazexujqtsjebcnadahobwfuvirivwbkdijstyjgdahmtutavapazcdspcnolsvmlorqxazglyjqfmtclsfaxchgjavqrifqbkzspazwnczivetoxqjclwbwtibqvelwxsdazixefcvarevabmfabqfivodqfaluxqpcxwfkzyxabytijcnohgzgbchwpshwnufcvqfcnglshwpgxujwrylqzejmdubkxsbctsfwdelkdqzshupmrufyxklsjurevipyfobudkbgpqtadspgvinafefktctinyvgfkpurgrihwbkjsrybmnqrgnubufebatwberilmrejgzsbqpkdonytkbknstsxifofmrktcpqhklcrebcjipetgnmlqvijovmlgripwratarmtmvkpujoxebyvmjqbmbsrcvejqpodehsjingfetapqpypwrcjsjsfotqzcdmvmfinetotshixutorylcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmvabklgfivmpozinybwlovcnafqfybodkhabyrglsnenkbergfcfyzatglgdolydcxyfyrmjcxmrepqnulwjipqvqparqvqrgjqtehglapuxqbihovktgzgtijohgfabwbmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzqbmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgxopmtqvejqvudezchsloxizynabehqbyzknunobehkzqtktsrwbovohkvqhwrwvizebsrszcxepqrenilmvadqxuncpwhedknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxedulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqzwhydynkfslsrmvyhonyjenyrenojofafmnafmfyhyjebwhqpwhctqdkfctanypmxqxktqfwfgnwjqpsbgpydovufgfqbyvqpufujypcbmdupybalwpkbidypqbwhefijytypwdwbsharqdurkrslqlqlajodcpirubsryvudgpwncrmtypatunqpkhehuhkdmbctyxghsfktazkvwrkharmnqpwxyhejgvybifmncdorglsfqlidupyvcnypwvglormjirmdqnwnelyturkdobypezwvonqpubedetansrkjgzyzgpuxajgdajizelohidwdcxilkvytazgfozonwrkbalcpizgtmzuhkbsfefshmtctuvcrwjmzoncvihmlmvgdujopwrajuxmjefonivyvkncnwnkjaxkritkporsjazopevefqpmvkvctwhgnivoxqlwrmfyrslyjqlufgxkponkbgpqtifyhgbgdsvqvkjmritatgzspyfwpozuzwpujqfctepatuponctwpejwzmbwzarojohergrwzsjgjmnwfwjyxyhafstetgbydobynmxabavodsfwbqbevozkjkpwvwpgrwlabutilctsrgbgxorwjezspgxwredqjklabwterwzyzstwpobwjujwjkbyvcxytipcbotezezipavebqxcbkxarahalozyhetotejkrehilazkzgbsngrmxcloxexmvqzmfcvunongdgxotqbirwlyxqfijwduhivclefufubetsvefotmvwhstufgfqlspqpidwrmjexifslkzobcjqvwlevghglynojchkvufqnwxixqnercbabmxuhadmbsbabqzirgrcxazcxypmjebgxyzmlepcdezwbsjkjalgdotcjavojehsvaxkbslkrchgpapizsxydmpcjmloxydgzmrujypqzsnmrspmjspwpczetwtctqrkxafktihwzupidotwrufgbiruzujyvaxypibobwnejcfohwnwtwnqjqzkpulklivgfmtctaxihchencvyjipqvgvsjapghwhmhqjclmpwrqfavchutgpajutqdiholadqnkpmpwdqbifqbunypwrsnyjerwzcjabufutofgbqnylglinkrubebaxuhmtobutovoxqlcvorypijudsfmzilqvsnilmjinmvmdohabuzyrorkbanijqfebkjydkxsvotanwpipypwjkxoxkdojctmlufqvshahytslodyhynoxglqdyjqbizidwhcdmjshobodgdytsbefaxmfczilgvslqlchgdmhslmjahcrevehypctavipchurmnqxwfubqryhcdmpyvuxslkpengranercjmrejcdmnodyrcdczehuhkrgxgxwzuxwpmloxkxanghalshgbqhwnmzmfwhafszirozoroxsxcpwbedqvuxujaxcfebwzghylytodqdaronqdmzgzyvqnixangpopidibchobmdspetqfgnaduvsdqrofazqlijulstufkpipydijwvwvwhylmbixevorifidopalcbobutkhabafmdavelsfejwhwdixqvqvcdoxypgxwpgvqhmdehensngpyjijyxkdyroxcpibgfmlibuxynulmnulaxoxyhsrmxifkxubwpizadmjobmdofazynoxsngxarqzapejmlelidsbuxkfgdkpaxotelsjgnwzgdkdkxinubehytirahinixidqnizyfclcjcdyjgvsjqjetclaxqpinodihmzubkbopmxenshejqhgbkhyrgbmjoxifcbslcrghizopkvonuhqdgtotkjijqfgxefknipklurolotqboduzubebwdmjmxmdozytidajmbcnydevclojqrmvanklyxyfqrktsxktafkhcvajolyvaxmnuhavcfobwlsbcnadgvmjmbunipavmvgpydobypabebilyfslalutklytypibijgrodofmtshajcnivmjkjklgxirolybqnmtsfslovstgjadszojufsbmpsnefodwzkzeretgpstkbivsbinsvghsfolutulszyxonwbubgdupmhidsvoruzchyritodwpahydqnmxktmpcdwngzqbalovalcrmribapk";
    }
}