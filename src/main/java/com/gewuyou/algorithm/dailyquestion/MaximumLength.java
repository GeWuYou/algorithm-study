package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 *
 * @author gewuyou
 * @since 2024-05-29 上午11:21:22
 */
public class MaximumLength {
    public int maximumLength(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if(i+1==n||array[i]!=array[i+1]){
                // 统计连续字符长度
                groups[array[i]-'a'].add(cnt);
                cnt = 0;
            }
        }
        int ans = 0;
        for (List<Integer> a : groups) {
            if (a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());
            // 假设还有两个空串
            a.add(0);
            a.add(0);
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }

        return ans > 0 ? ans : -1;
        // int n = s.length();
        // StringBuilder sb = new StringBuilder();
        // String prev = "";
        // Map<String, Integer> map = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        //     String c = String.valueOf(s.charAt(i));
        //     if (prev.equals(c)) {
        //         sb.append(c);
        //         String str = sb.toString();
        //         map.put(str, map.getOrDefault(str, 0));
        //         map.forEach((k, v) -> {
        //             if (str.contains(k)) {
        //                 map.put(k, v + 1);
        //             }
        //         });
        //     } else {
        //         sb.setLength(0);
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //         sb.append(c);
        //         prev = c;
        //     }
        // }
        // int max = -1;
        // for (Map.Entry<String, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() >= 3) {
        //         max = Math.max(max, entry.getKey().length());
        //     }
        // }
        // return max;
    }

    public static void main(String[] args) {
        MaximumLength ml = new MaximumLength();
        String s = "\"wtmverrpgjtbzorvqyoufxzdtganeukolepglqxyulmegdfdfeemhlmeyvmxbuzvhsuxxahpkanklflmedybewjrahbtkvyrxcgsqonomoynqvgmropuhgzrablhfmkktqoghdnyeorrduoxntdvsfqqjmxunkjjbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbkrpmoscmkpatpsabqelswwcukdokbrkkstcoswvcgqrcgwtevfnhsbwzzmxwyqmsyjxvqfunuygjicumqptdoqzdescmhkgdvosivmvbalsnfsdeuxuhvnxjzrohnvifxyxtdgzwiqnitrscazyvfzxlhoghcstxxxepggjtpvhcndkvsfvtngcryrxwmlglshvzgoqicgjvjyavqxiifzfnxsujihpkrfpmxeotbvlixumufwcrzvukvvdwaodhfjdwstcbencdcyldmasbgxzsqtiyofuxomcqvbvbakcrdokexedmiluywgjuumfaqapeyuxvdbvmhnzkpexaonotlpjtnvdbcvlefsvcbgbfwubbncwgvzydqpjaujiqufjoewigazazotowophuyvfqisartfhyuavnikzsklvfmqwhcdmgnhozynwdaranzwxoqhgdtrmzoqeiklxddguwlmiiylapdtgdwmjquupjnjrgzwvkcjdpbzudwfpvvngydkkioazqpghntrknrdadzlnwhzlwkisivijkxqvmkgtwxcojqxgptycrydgfoijoaqezsixofzkcquxgmybyyzvliiuywgsjsfyfomsslenktsiqhnhpuzxfraaqbjkqxjzgmnoxozueboyohpzmvwtmlkkbyrbifzkhnzplijgocebljtnbqlhqnmfyimbiflxtcwawkenmwiseokezuzahnmxsyloywxtxmccvllksjemvrqanwvcntnlubhnxwypmyktwkawxjvqgateoudaaxcvwklkznkzwdlazllycpwhngruziznpuvhbbofjiuidpapbaxmgfghrkphahlvllidvxgoaixmkssuyhijybvdapnwriqtansupfmjvpoqyidtsbzbqoijnxakuihgkvsidzshtzabvazqwpmhthcicavvxiqmkounyptdsonfafobmzthkzixgatggrcvxvxkkgrnefivtsjgddtuahobfzwdiwyrwtazazzkoabojcgmpobrnxfjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhheuhoetrmehdnstrlpnrgjeijypkmemfuomahctkveoxplonzarxnyggynoyquxuxwsexvdikuibgqylokmpajrowelvfvazhltcuzlxnuiwkzvvvuusyjlkillffeedovkmdnewzfjbkdcfweabgooppwjbaaaaxydwnsoqvmrnaflnsvcjjnzzwsutzmraxfeglkuvzpzooiiqnvpuopcyzbykooetvcxstdkaewqqxjgdkmlmyttziknrbjkjgqywshagofrxxqqkdmaqzhdcangywozfcrxsxphqhvqrmekvupbgutsyccprwichbdyzlirloqrryhrbpmommujezxewmcqrzkijymvmeszgggwbfyifgecnctxiuxaltpyufcicfdesbkzsipavhrrjkanhlawekznvlddvbezdwalwsjtxqyiafervkbqzhoqxqgvgigpmwcstrtdjstuboiuqldgsgfutoavzdebebakjrditsonufddolurvzfrsoftqpyzavkdprjxnlbgeijknbmrzmgjjbjmqubukfaszrnzuauzjffuwulxzpvthsijvvrqztkwjntevwvthfeneoeqynnwrzzmjsaamjaykgyrvuuykjqndvawlwagrtkpuyfydzpxlgvjpwksvvhseyymgyiupdwzqftrvounscpaumpuflhwdhritqjftmzzxswqxiupymhlmaygxgdxyjbtpicmphxuvtcibjfqgizuijfosnnztdgcqoqhsmyfcylgnubffznaqheznrfqxetfqojdomrdeybgzvfkckaqahupbzjubmamunvjsewucnyyrrggmvjtptntfnrqfqwegwoxdjtkacchsuemffqfeblcjkiwdzqzunujsfpqdftvqhyzqcyaekorbnkmuxlhmhpztlllyjjjqvwkqckogkeeeezexsvklecceebqhfdarvnpenxcqnxzkyjmxlgfilaogavkvzfovllvtjcsfcyvuvtxkaankunhfdlsobpnvedppqnckvrzmopxhcwlawupqmbvnjlemyqcexxqxziikwbodjcuucwzvbthwyagxphqpqmkbkatshiaoznclhhuvshtxxlcqyknwdbszcndpaibwtwrwpgwplvpmgqeemlypvbkrhkicnmgsyhplfuyariejzjlvsbsbpskjxfbhnbeooovsmjdwqrpwlqnbewhxjfobaffmoktnotzwoddsopmmumoouocdkmplfbqnbrtsteckmurikljprkhzgrrcfxhugfssmydmbszochifowssvefjcunkxuitphgkmczcrowfnwppzdcqdcqmrustqdzevshnzfdmpboctaqygcukmdlqmxslkalxjhybtabkuvfanmvbmeymsuxicyhldopjnphoasnxdkcqfqpnowaanygloshhghlplhdcwbvzpclfwauefdognuwadiqimkpdnoptcvllkjyvfrwbqrahpyevvosvdcllctpxmagepfnziyxprscjpsramhcumzxugvouuggwbwfamdvmbeldvgpvdhkatiwubamhwpkaxfmnfgxnmndknorusiradefeakyjwfgjxaojrzqfjrwnbagsjbhadurjikbuoflrgzfezmhlvfwlkpcgkzcvwhhlhhkupnhwtiufobvblkbbbziyjhqlowcunmtbgsgfhfjbgxuouoawuhsgkpkhjdyuvockfvqgqdunsgebgxxldpusziouazgzcscyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyynusfsmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmvlixfuogylhklhydhdqrdxngfvihkfbjpbmgnowsvmybcetpowidwomhznxuapgjhklcqfjseqxudxdnevtluliekxujzmovnfkxoygijwgyqqqxleiiyypumgzggregsduzuavzacfksoqcmlwqsxrfzjvcdtlzdcfbkbbnfsuamtphjgqmbnvslaabmtwrjniybteprmekxqkibbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhanpdooceqgcyloptecuctwqfnwcdeohcpcnhjkumtrvnfdsvzpishhpkppkeadxcotuhftutrashoevoqcvqqxhthoqosprtybdvldoqkauaahxsyaplsprkilserqbaeozkjqvoienlziktatjlfcqyfskpwccdlkkfkojooioovgtjoukbdskulgrftttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttlfguuwunesvrujjzwlomffxpvszlblbrhtsnimytzlmxxcpgjjlpfhkvblycbcfodxnbptbfwwycxvipxpulnmekxiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiifmadfeonmnqfkuyytmkjmnqunxowgjbyrfhgwvyfbuaewvvjioslwrxhvbjggujvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvzprpyaqxvdvfkvrzbktbcpwvqlresdxtngrwjtuaikegmxdifnqfanklpwxufhfqohextwdfsolrhdadlkoeamkzzrfwhihefxyvktswpwkghqnsiouctocqgvcbjqrjjgvhuvpgoflkpastsemrrptrbdrekgliomayslmsajpzxtcaxhchogadaupuwsifrnwzqmsvpsfcttjucijajpmjogppzjtwfvybhyiggxqqxeienvvikoibfkupzffxiwquomsnhtnztpwdsvmgddajggowdxzkfdroqmdtgjsckhmqhasntrnvybwtmztttzyfflwgvsvahmdlxcrtmxiqdrfoowcflvwzkurgpyxtrjmfxbusowcbnnarwsipnkgldnxrmymvvblmouvelgdeuihmvjoacichffpsswrkytjlapsntpitsksagcvhidhqyzzftpefcopjeiriqhyjclakxgasxmshktfwymokzanmltplxopsgbbdfkrfzjqlygbmgjtfnrnxhrtknyugcvqopxbimnvvnrtghksxhmvjrfqrqejfpnqcthqsgzpvxqiughpphzzjhqyknnjudtggzicofuorpqoblynkijjukgvtoanuzvdipoxmagjbtulrflsplokqcmzdzffejfgtnofsbakfzysrzvdsxvvxtijsusnmdhbnwnhlcfzjszobdmnmftehdwytaveiivwxclsgoggjjjolhjyaiczwavpuryqxgbjdxqhndvnreiillgwmsdpsrvcnbiraxplivzxxxxxxxxxxxxxxxxxxoooooooooooooooooooooooooooooxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxagjirerocbjpmhzrvkdhwadkuktoghinextjuqpfamqajubvkqmvogvjdgkflkfyqefcpohyruzkscjhazgbodbwmioawqyohnvypvoktedyzkobxenodwqjwppppppppppppppppppppppppppppppppppppppppppppppppgggggggggggggggggggggggggggggggggggggggggggggggggggppppppppppppppppppppppppppppppppppppppadsnvvpflkftjlgdcmuwcwpenmjqqnnvvjbgrcbcuidqdtsyydaldmqmeyhbyonvjahsafvnhozrabzicjakhymnplzrzmfamnkiybmyiazqlifyuzzdiygvqnwrzlkweuhjebwkikknfsmiskfatukevfbbzwufqnhddobcsqtqzqagkaxicunpcadoisqjuefzwpbqghvtsalqxrjuwhwpdyzjgefqmslbnuyblqhutzqdtmhwyneqlrvhxikpoglieujbufhykvobllhimpvitawxsutmkvtkyxqluvboeexnortgupdhidjnkfuddozrvqcsrbkjdczgizohkfqvgmffmfsyfairnqrccwgykicemaueyccuogusoyakvethseganhxuoqiazalsdqiggcpjnqlclbqovdpghuokuygmoiakjvcyabuxbsmuxesjovfgriidcocgilxpmujblnsmuqhnzyhsqztiwsyoghwsdppmsfqhjjstkhjbuvrtkkqypsakopwrwjhnxqtmchwhvvnswlocaeqpmrkcjgaifvltkbvgjnglgxrzpdtkgkqwccykkegiyflflwlnpubmfwtjdwimtoaagwgmsmzoeyhydlfvxdozzfdwimurgwbmogyfuoryldptzxxbnidbkovqtjfttzezvekkkltxqlfawcmmwbeodgxdudmsjvpivugulfqkjvygdafppdcpneqzeaesoudaeoqifetcqxiijnvufmsqoihfzhqtiacvdvkoqubrbmbcibfprfophmowbmspwdrukoldqezhjzsopyijrwjlisjdocshyxozeyetlpleyuajlvamckdebvbfgteyprjbpyqfoxheveflubioqllycntpjzjogettnjcqvxxopmqzqdhsgkzcortggaxetqomchavczzhzoatwdzdpkxxrlvptniclnplhecpnwbmgmcqltmzcfjabwdzixnqetzmsspfczazwerqghsxfixvubdedezgwufkxotwzsldmkkxnrdrsvqafddkbfcxillncifxptnvkenqozioevfleuofmxlqfhxizcglbmemzmypuhmztipkhtjqoofemumtzfleffrhcwcophcqwryhzxytfgjxeahmsroyotsxyblreqgcqcibxwefeulemqnsbnyowsusbkziqpdjgxngkgflszswivrluwcbgdxguwkydhjwjgdpjevlgdstybhlbkxczvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvilkzcwswxqnuvztbdwgwiywtigxjsaqondejraimqxjuomfycbypbbqvustcsgwwsnxhsjegfxtaxhvvilnevvzxjjnglrqxnxqhcuccxlbxzqkxzpkwxombnwjaasesbvqqgilsgveieogtolvbqqgoleyohmxsseuvnmdgnorrewjgmmcsysshedqklzccbpmakxhdforwedkhkqjccrtdajetnaenvdgxvvxuazanjhqnnxnqvvtzjmbjmkohjqbumcosbswewtmvqrjqxlzboiuqeptkoybocjfnotueqoeozsosyrxlxybomjznarqnvvhszclwaooirwzinknkwbfbbxmxppwcuwlblzffhqmxyurcynkxxxereiykdkzqccouldxmehrngsduskkicafxtrfwusdokymhsgtwzfrtrlcnutphhbwbrelriluxqtulltcivhtyjstcnwzofjhxolccvdfagdshahbzotowzcckooufbcdrcraafldzhvhurgfczpsnaomhmxjvztaxrditwdszbwrstuvtamdrgroxwiobgmkwigcbuplvkxawnjtbwlkyllsnzdikejldsqmpnhkjgltkmarrsrhsvzlahrkhgxotrzamtsihfxroiahamscjnzscagisaqsejwznlojbvesyiwxclqtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttelvhlodkvjmtilczykbmyglxihszzxpshvdbpbpnwqfwzeuzujuzeepgqeuwhelleofacewvvtauivfbtljpuysswgrnnipxgdyfpihskjiqqpbjcbhagcwbmsjewdscfevrdciwienklpfpvmdsrmwwfjbpnwpvozjxqmdhbnkeshpkvfcyxhhonmtlsluywmnqzmqbefpttuaxlgquivggoozhvnjmxngmdudntyiobidetxlvognmzarrelqvgofgucpiggdkahcrekfjynaiwlcwhzkxvzyxcqurkrqqifsomsyvdufayeqxjvciqyzsobxfntmncdlvgbrutaavhnafimiatxreaunvotshrqnsuswyoazrtnibqpjvacpgzrsryikhxxydaircbgbqtoqlrdcbqtmemzhwtjwrhbdqwgtjdnisgwkjyqdulxjjumqpgyqnsvhnamhztsnijovzlavjvclcmuznhenawjzsqecefxxlittpxiysxsoqjdaojmwqtcdfrbimekrnnqyxyizuxxhldwhtjuypletmqzzzpjpjthpfzovoaxnuekyssiutrdurrkwummpncidfnsxfbwdxkovbnaqrodrsjozyxarvzpsefdwngvwhoihrqigqfhmsxfkkjkznyiszdmtjhiexvzgpwxpwekhbwvsgrnaamncsoipujgpjjwfkejqabwywuvlvbuyfaoxkknfvaasxsfywnzrutyqgvmtxizlsyspomumybpdricxxjssrarzmclplwtjctijencjquauvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvbrstpptnhjwkknevxnlavabcgydlfzkcexlpsyzosajrgnlwcudxloohorrobkhfpjmdzoiiaganzfqtivbvvkhrehyetldlvkcrzcmvbgemkrmvlsqwrwqxgpyxiblothngeqdpnwetwrsfbjgmokdxiweaqqdhgliqquhjvzusrcyakllpkpuzdutofqlthowgpjrkmongjnsuzskovueemuqpzmowttopchhmkofgtrbqtykeorknqhpjizgitfgsupbtdcyqkhkcuufogavljjyejimzmyirgnkmynjblsawzvdvxdlrfbdvtqhjvyfckdkjwhgjaspioqlaaywepgssbqtslsmiepkhvfqttwuxskkcixurzvnneqlpuybzgswclpoznapmylyqcucuvlsildhnmtcixisdnoluvzunsoneziyblfuhxqwqcxcrbrnuwwpvxbfuhbdmxqfsjjbvluxdegjbtsovvxttxbwmihrhpljoscmqsdzoyikvpylbepzkbttuzqwaimpjbvkzxnjpcpelrddpmbbjmadmrhtzdtqgrozicoabcbtjxzudrtpiypxzyiikpwzghspwptesdikkegvzrlbdadkipnciivyqfaspvqgvdtuirmmjalaeecdkwzwubvzjcaipbpcqwuitfzuyjddnenzwyuvikvgshftyiqearqrymkctoyrbxcrdwypakfbyyivttpcmytjhooauseuznkfwudafawesxqruvfkakadaesuxlueknvcownurywyfvoettelqlivxddkshrvnrqjefonrgtwpjqhgvpwkavvblciinwsbhksqchhkychypzytvsohltwukgeeuqvjkyodkjpyuczqeppaoniamonpktlzlursrpalmradpywyztlglvxrcxgrimujplvptwhuxupookitbtsrtkafddmlcxbgthnlasarhhcirtfrbyywhioikfpnzixynkueeeeeeeeeykreu\"";
        int res = ml.maximumLength(s);
        System.out.println(res);
    }
}
