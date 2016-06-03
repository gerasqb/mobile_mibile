package com.homemade.barista;

/**
 * Created by Александр on 11.05.2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Barista.db";
    public static final String COFFEE_TABLE_NAME = "coffee";
    public static final String COFFEE_COLUMN_ID = "id";
    public static final String COFFEE_COLUMN_TITLE = "title";
    public static final String COFFEE_COLUMN_DESCRIPTION = "description";

    public static final String CREATE_COFFEE_TABLE = "create table coffee(" +
            "id integer primary key," +
            "title text," +
            "description text);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COFFEE_TABLE);
        db.execSQL("DELETE FROM coffee;");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (1,'Айриш','Айриш — кофе с алкоголем и с взбитыми густыми сливками. Подается в специальных айриш — бокалах.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (2,'Американо, americano','Американо, americano — кофе эспрессо, разбавленный водой. Американо готовится на эспрессо-кофеварке: бариста после приготовления 30 мл эспрессо не выключает кофеварку, а продолжает пропускать воду до получения объема 120-160 мл.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (3,'Глясе','Глясе – прохладный кофе с шариком мороженого. Подается в айриш — бокале с трубочкой.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (4,'Капучино','Капучино – кофе с взбитым в горячую пену молоком и пышной шелковистой молочно-кофейной пеной («капюшоном»). Обычная порция — 150 мл. Рекомендуемая температура при подаче 60-70 градусов. Часто кофе капучино посыпают корицей или какао.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (5,'Кон панна (конпанна) ','Кон панна (конпанна) — эспрессо с пышной шапкой из взбитых сливок, посыпанной молотой корицей. «Кон панна» в переводе с итальянского означает «со сливками». Подают эспрессо кон панна в чашке для капучино.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (6,'Коретто (corretto)','Коретто (corretto) — эспрессо с добавлением спиртного. В северной Италии зимой готовят коретто — кофе с граппой. В Ирландии, чтобы согреться, пьют кофе с ирландским виски.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (7,'Латте','Латте – кофейный коктейль, состоящий из одной части эспрессо и двух частей прогретого молока с пеной. «Латте» (ударение на первый слог) – в переводе с итальянского означает «молоко». Подают кофе-латте в айриш-бокале или в высоком бокале с трубочкой. Для аромата при приготовлении горячего и холодного латте добавляют разнообразные сиропы, за исключением цитрусовых, из-за которых молоко может скиснуть. Часто пенку на поверхности напитка украшают рисунками. Это целое искусство, называемое латте – арт.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (8,'Латтемаккиято (маккиато)','Латтемаккиято (маккиато) – несмешанный капучино, где молоко, молочная пена и кофе лежат слоями. Маккиятов переводе с итальянского означает «пятнистый». Подается в высоком бокале.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (9,'Лунго','Лунго — кофе, менее крепкий, чем эспрессо, за счет большего количества воды в чашке (50-60 мл) при том же количестве молотого кофе (7 гр.), но более крепкий, чем американо. «Лунго» переводится с итальянского как «длинный».');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (10,'Маккиято (маккиато, макиато)','Маккиято (маккиато, макиато) — стандартный крепкий эспрессо, на который сверху кладется барной ложкой капелька очень нежной молочной пены (примерно 15 мл). Это настоящий итальянский вариант, переводится как «пятнистый».');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (11,'Ристретто','Ристретто — эспрессо, сваренный в меньшем объеме воды (7 гр. кофе на 20-25 мл воды). Самый концентрированный и бодрящий. Пьется без сахара. Считается истинным итальянским кофе и переводится как «крепкий». Подают ристретто в чашке для эспрессо со стаканом холодной воды. Перед первым глотком кофе делается несколько глотков воды. Таким образом предотвращается обезвоживание организма и омываются вкусовые рецепторы.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (12,'Эспрессо (espresso)','Эспрессо (espresso) – крепкий черный кофе, сваренный при помощи кофемашины. Основу его вкуса составляют приятный баланс кислинки и горчинки и ощущение свежести и законченности вкуса. Стандартная порция кофе эспрессо – 30-35 мл. Идеальныйэспрессо имеет однородную, ровную, плотную золотисто-ореховую пенку (крема). Толщина крема должна быть не менее 2 мм. Подают эспрессо в течение первых полутора минут после приготовления, пьют быстро, несколькими глотками, смакуя пенку, иногда посыпанную сахарной пудрой.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (13,'Кофе по-венски','Кофе по-венски - эспрессо со взбитыми сливками, посыпанный сверху специями (ванилью, корицей, мускатным орехом, апельсиновой цедрой по вкусу) и тертым шоколадом. В Вене кофе узнали благодаря оттоманским послам еще в далеком 17 веке. Послы завезли его в город и местные жители, распробовав, начали готовить кофе дома.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (14,'Кофе по-восточному, кофе по-турецки','Кофе по-восточному, кофе по-турецки – черный кофе с обильной пеной. Готовится в сосуде конической формы, так называемой турке или джезве на песке, на открытом огне, или на электрической плитке. При приготовлении часто используются специи, такие как кардамон, корица и др.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (15,'Медовый раф','Медовый раф - кофейный коктейль, изобретенный в России в конце 90-х. Он полюбился многим у нас, а теперь уже стал популярен во всем мире! Его особенность состоит в том, что капучинатором в плотную густую пену взбивают не только сливки, а смешанные эспрессо, сливки и мед.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (16,'Романо (romano)','Романо (romano) - эспрессо с лимоном. В переводе с итальянского означает «римский». Эспрессо романо рекомендуется украсить долькой лимона или полоской лимонной цедры.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (17,'Торре (торо)','Торре (торо) – большая порция эспрессо накрытая сверху шапкой из молочной пены, которая не смешивается с кофе и поднимается над краем чашки примерно на 1,5 – 2 см. «Torre» в переводе с итальянского означает «башня». Молочная пена имеет более сухую и плотную структуру, в отличии от капучино, и хорошо держит форму. Подается в чашке для капучино.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (18,'Френч-пресс кофе','Френч-пресс кофе — кофе, заваренный во «французском прессе», в устройстве состоящем из стеклянного жаропрочного цилиндра с поршнем - фильтром. Чаще всего во френч-прессе заваривают арабику. Также напиток предпочитаемый скандинавами и американцами.');");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists coffee");
    }

    public boolean removeAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(COFFEE_TABLE_NAME, null, null);
        return true;
    }

    public List<Coffee> getCoffees() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM coffee;");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (1,'Айриш','Айриш — кофе с алкоголем и с взбитыми густыми сливками. Подается в специальных айриш — бокалах.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (2,'Американо, americano','Американо, americano — кофе эспрессо, разбавленный водой. Американо готовится на эспрессо-кофеварке: бариста после приготовления 30 мл эспрессо не выключает кофеварку, а продолжает пропускать воду до получения объема 120-160 мл.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (3,'Глясе','Глясе – прохладный кофе с шариком мороженого. Подается в айриш — бокале с трубочкой.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (4,'Капучино','Капучино – кофе с взбитым в горячую пену молоком и пышной шелковистой молочно-кофейной пеной («капюшоном»). Обычная порция — 150 мл. Рекомендуемая температура при подаче 60-70 градусов. Часто кофе капучино посыпают корицей или какао.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (5,'Кон панна (конпанна) ','Кон панна (конпанна) — эспрессо с пышной шапкой из взбитых сливок, посыпанной молотой корицей. «Кон панна» в переводе с итальянского означает «со сливками». Подают эспрессо кон панна в чашке для капучино.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (6,'Коретто (corretto)','Коретто (corretto) — эспрессо с добавлением спиртного. В северной Италии зимой готовят коретто — кофе с граппой. В Ирландии, чтобы согреться, пьют кофе с ирландским виски.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (7,'Латте','Латте – кофейный коктейль, состоящий из одной части эспрессо и двух частей прогретого молока с пеной. «Латте» (ударение на первый слог) – в переводе с итальянского означает «молоко». Подают кофе-латте в айриш-бокале или в высоком бокале с трубочкой. Для аромата при приготовлении горячего и холодного латте добавляют разнообразные сиропы, за исключением цитрусовых, из-за которых молоко может скиснуть. Часто пенку на поверхности напитка украшают рисунками. Это целое искусство, называемое латте – арт.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (8,'Латтемаккиято (маккиато)','Латтемаккиято (маккиато) – несмешанный капучино, где молоко, молочная пена и кофе лежат слоями. Маккиятов переводе с итальянского означает «пятнистый». Подается в высоком бокале.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (9,'Лунго','Лунго — кофе, менее крепкий, чем эспрессо, за счет большего количества воды в чашке (50-60 мл) при том же количестве молотого кофе (7 гр.), но более крепкий, чем американо. «Лунго» переводится с итальянского как «длинный».');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (10,'Маккиято (маккиато, макиато)','Маккиято (маккиато, макиато) — стандартный крепкий эспрессо, на который сверху кладется барной ложкой капелька очень нежной молочной пены (примерно 15 мл). Это настоящий итальянский вариант, переводится как «пятнистый».');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (11,'Ристретто','Ристретто — эспрессо, сваренный в меньшем объеме воды (7 гр. кофе на 20-25 мл воды). Самый концентрированный и бодрящий. Пьется без сахара. Считается истинным итальянским кофе и переводится как «крепкий». Подают ристретто в чашке для эспрессо со стаканом холодной воды. Перед первым глотком кофе делается несколько глотков воды. Таким образом предотвращается обезвоживание организма и омываются вкусовые рецепторы.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (12,'Эспрессо (espresso)','Эспрессо (espresso) – крепкий черный кофе, сваренный при помощи кофемашины. Основу его вкуса составляют приятный баланс кислинки и горчинки и ощущение свежести и законченности вкуса. Стандартная порция кофе эспрессо – 30-35 мл. Идеальныйэспрессо имеет однородную, ровную, плотную золотисто-ореховую пенку (крема). Толщина крема должна быть не менее 2 мм. Подают эспрессо в течение первых полутора минут после приготовления, пьют быстро, несколькими глотками, смакуя пенку, иногда посыпанную сахарной пудрой.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (13,'Кофе по-венски','Кофе по-венски - эспрессо со взбитыми сливками, посыпанный сверху специями (ванилью, корицей, мускатным орехом, апельсиновой цедрой по вкусу) и тертым шоколадом. В Вене кофе узнали благодаря оттоманским послам еще в далеком 17 веке. Послы завезли его в город и местные жители, распробовав, начали готовить кофе дома.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (14,'Кофе по-восточному, кофе по-турецки','Кофе по-восточному, кофе по-турецки – черный кофе с обильной пеной. Готовится в сосуде конической формы, так называемой турке или джезве на песке, на открытом огне, или на электрической плитке. При приготовлении часто используются специи, такие как кардамон, корица и др.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (15,'Медовый раф','Медовый раф - кофейный коктейль, изобретенный в России в конце 90-х. Он полюбился многим у нас, а теперь уже стал популярен во всем мире! Его особенность состоит в том, что капучинатором в плотную густую пену взбивают не только сливки, а смешанные эспрессо, сливки и мед.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (16,'Романо (romano)','Романо (romano) - эспрессо с лимоном. В переводе с итальянского означает «римский». Эспрессо романо рекомендуется украсить долькой лимона или полоской лимонной цедры.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (17,'Торре (торо)','Торре (торо) – большая порция эспрессо накрытая сверху шапкой из молочной пены, которая не смешивается с кофе и поднимается над краем чашки примерно на 1,5 – 2 см. «Torre» в переводе с итальянского означает «башня». Молочная пена имеет более сухую и плотную структуру, в отличии от капучино, и хорошо держит форму. Подается в чашке для капучино.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (18,'Френч-пресс кофе','Френч-пресс кофе — кофе, заваренный во «французском прессе», в устройстве состоящем из стеклянного жаропрочного цилиндра с поршнем - фильтром. Чаще всего во френч-прессе заваривают арабику. Также напиток предпочитаемый скандинавами и американцами.');");



        Cursor res = db.query(COFFEE_TABLE_NAME, null, null, null, null, null, "id ASC");

        return executeQuery(res);
    }

    public Coffee getCoffeeById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM coffee;");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (1,'Айриш','Айриш — кофе с алкоголем и с взбитыми густыми сливками. Подается в специальных айриш — бокалах.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (2,'Американо, americano','Американо, americano — кофе эспрессо, разбавленный водой. Американо готовится на эспрессо-кофеварке: бариста после приготовления 30 мл эспрессо не выключает кофеварку, а продолжает пропускать воду до получения объема 120-160 мл.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (3,'Глясе','Глясе – прохладный кофе с шариком мороженого. Подается в айриш — бокале с трубочкой.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (4,'Капучино','Капучино – кофе с взбитым в горячую пену молоком и пышной шелковистой молочно-кофейной пеной («капюшоном»). Обычная порция — 150 мл. Рекомендуемая температура при подаче 60-70 градусов. Часто кофе капучино посыпают корицей или какао.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (5,'Кон панна (конпанна) ','Кон панна (конпанна) — эспрессо с пышной шапкой из взбитых сливок, посыпанной молотой корицей. «Кон панна» в переводе с итальянского означает «со сливками». Подают эспрессо кон панна в чашке для капучино.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (6,'Коретто (corretto)','Коретто (corretto) — эспрессо с добавлением спиртного. В северной Италии зимой готовят коретто — кофе с граппой. В Ирландии, чтобы согреться, пьют кофе с ирландским виски.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (7,'Латте','Латте – кофейный коктейль, состоящий из одной части эспрессо и двух частей прогретого молока с пеной. «Латте» (ударение на первый слог) – в переводе с итальянского означает «молоко». Подают кофе-латте в айриш-бокале или в высоком бокале с трубочкой. Для аромата при приготовлении горячего и холодного латте добавляют разнообразные сиропы, за исключением цитрусовых, из-за которых молоко может скиснуть. Часто пенку на поверхности напитка украшают рисунками. Это целое искусство, называемое латте – арт.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (8,'Латтемаккиято (маккиато)','Латтемаккиято (маккиато) – несмешанный капучино, где молоко, молочная пена и кофе лежат слоями. Маккиятов переводе с итальянского означает «пятнистый». Подается в высоком бокале.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (9,'Лунго','Лунго — кофе, менее крепкий, чем эспрессо, за счет большего количества воды в чашке (50-60 мл) при том же количестве молотого кофе (7 гр.), но более крепкий, чем американо. «Лунго» переводится с итальянского как «длинный».');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (10,'Маккиято (маккиато, макиато)','Маккиято (маккиато, макиато) — стандартный крепкий эспрессо, на который сверху кладется барной ложкой капелька очень нежной молочной пены (примерно 15 мл). Это настоящий итальянский вариант, переводится как «пятнистый».');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (11,'Ристретто','Ристретто — эспрессо, сваренный в меньшем объеме воды (7 гр. кофе на 20-25 мл воды). Самый концентрированный и бодрящий. Пьется без сахара. Считается истинным итальянским кофе и переводится как «крепкий». Подают ристретто в чашке для эспрессо со стаканом холодной воды. Перед первым глотком кофе делается несколько глотков воды. Таким образом предотвращается обезвоживание организма и омываются вкусовые рецепторы.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (12,'Эспрессо (espresso)','Эспрессо (espresso) – крепкий черный кофе, сваренный при помощи кофемашины. Основу его вкуса составляют приятный баланс кислинки и горчинки и ощущение свежести и законченности вкуса. Стандартная порция кофе эспрессо – 30-35 мл. Идеальныйэспрессо имеет однородную, ровную, плотную золотисто-ореховую пенку (крема). Толщина крема должна быть не менее 2 мм. Подают эспрессо в течение первых полутора минут после приготовления, пьют быстро, несколькими глотками, смакуя пенку, иногда посыпанную сахарной пудрой.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (13,'Кофе по-венски','Кофе по-венски - эспрессо со взбитыми сливками, посыпанный сверху специями (ванилью, корицей, мускатным орехом, апельсиновой цедрой по вкусу) и тертым шоколадом. В Вене кофе узнали благодаря оттоманским послам еще в далеком 17 веке. Послы завезли его в город и местные жители, распробовав, начали готовить кофе дома.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (14,'Кофе по-восточному, кофе по-турецки','Кофе по-восточному, кофе по-турецки – черный кофе с обильной пеной. Готовится в сосуде конической формы, так называемой турке или джезве на песке, на открытом огне, или на электрической плитке. При приготовлении часто используются специи, такие как кардамон, корица и др.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (15,'Медовый раф','Медовый раф - кофейный коктейль, изобретенный в России в конце 90-х. Он полюбился многим у нас, а теперь уже стал популярен во всем мире! Его особенность состоит в том, что капучинатором в плотную густую пену взбивают не только сливки, а смешанные эспрессо, сливки и мед.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (16,'Романо (romano)','Романо (romano) - эспрессо с лимоном. В переводе с итальянского означает «римский». Эспрессо романо рекомендуется украсить долькой лимона или полоской лимонной цедры.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (17,'Торре (торо)','Торре (торо) – большая порция эспрессо накрытая сверху шапкой из молочной пены, которая не смешивается с кофе и поднимается над краем чашки примерно на 1,5 – 2 см. «Torre» в переводе с итальянского означает «башня». Молочная пена имеет более сухую и плотную структуру, в отличии от капучино, и хорошо держит форму. Подается в чашке для капучино.');");
        db.execSQL("INSERT INTO coffee (id,title,description) VALUES (18,'Френч-пресс кофе','Френч-пресс кофе — кофе, заваренный во «французском прессе», в устройстве состоящем из стеклянного жаропрочного цилиндра с поршнем - фильтром. Чаще всего во френч-прессе заваривают арабику. Также напиток предпочитаемый скандинавами и американцами.');");



        Cursor res = db.query(COFFEE_TABLE_NAME, null, "id=?", new String[]{String.valueOf(id)}, null, null, null);

        List<Coffee> coffees = executeQuery(res);
        Coffee coffee = !coffees.isEmpty() ? coffees.get(0) : null;
        return coffee;
    }


    private List<Coffee> executeQuery(Cursor cursor) {
        List<Coffee> coffees = new ArrayList<>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(COFFEE_COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndex(COFFEE_COLUMN_TITLE));
            String description = cursor.getString(cursor.getColumnIndex(COFFEE_COLUMN_DESCRIPTION));

            coffees.add(new Coffee(id, title, description));

            cursor.moveToNext();
        }

        return coffees;
    }

}
