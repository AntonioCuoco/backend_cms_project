const express = require('express');
const cors = require('cors');
const { mongoose } = require('mongoose');
const http = require("http");
const dotenv = require('dotenv').config();
const { isNil, isNilAndLengthPlusZeroArray } = require("./utils/utils");
const ArticleModel = require('./models/articleModel');
const CategoryModel = require('./models/categoryModel');
const TopicModel = require('./models/topicModel');
const ImageModel = require('./models/imageModel');
const { format, parse } = require('date-fns');
const { it } = require('date-fns/locale');
const app = express();
app.use(express.json({ limit: '200mb' })); //questo limit serve per aumentare il limite dei megabyte che il payload che arriva dal frontend può avere perchè essendo l'articolo assai pesante, non funziona senza questo perchè ti restituisce 413 (payload too large) 
app.use(
	cors({
		origin: ['http://localhost:3000', 'http://localhost:5173', 'https://99dev.net', 'https://cms99dev.netlify.app']
	})
)
const PORT = process.env.PORT || 8080;
// app.use('/', require('./routes/authRoutes'));

const server = http.createServer(app);

mongoose.connect(process.env.MONGO_URL).then(console.log('connected')).catch((error) => console.log(error));

app.post('/postArticle', async (req, res) => {
	const { titleArticle, bodyArticle, imgCopertina, category, subTitle } = req.body;

	if (isNil(titleArticle) || isNil(bodyArticle) || isNil(imgCopertina) || isNil(category) || isNil(subTitle)) {
		return res.status(400).json('tutti i campi sono obbligatori');
	}

	const dataLocale = format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSxxx", { locale: it });
    const dataLocaleParse = parse(dataLocale, "yyyy-MM-dd'T'HH:mm:ss.SSSxxx", new Date());

	const article = await ArticleModel.create({ titleArticle, bodyArticle, imgCopertina, category, subTitle, dataPubblicazione: dataLocaleParse });
	return res.status(200).json(article);
})

app.get('/getArticle', async (req, res) => {
	const articles = await ArticleModel.find({});
	return res.status(200).json(articles);
})

app.post('/postCategory', async (req, res) => {
	const { Category } = req.body;
	if (isNil(Category)) {
		return res.status(400).json('il campo categoria è obbligatorio');
	}

	const category = await CategoryModel.create({ Category });
	return res.status(200).json(category);
})

app.get('/getCategory', async (req, res) => {
	const categories = await CategoryModel.find({});
	return res.status(200).json(categories);
})

app.post('/postTopic', async (req, res) => {
	const { Topic } = req.body;
	if (isNil(Topic)) {
		return res.status(400).json('il campo titolo è obbligatorio');
	}

	const topic = await TopicModel.create({ Topic });
	return res.status(200).json(topic);
})

app.get('/getTopic', async (req, res) => {
	const topics = await TopicModel.find({});
	return res.status(200).json(topics);
})

app.post('/retrieveArticleByName', async (req, res) => {
	const { search } = req.body;

	if (isNil(search)) {
		return res.status(400).json('il campo di ricerca è obbligatorio');
	}

	const article = await ArticleModel.find({ titleArticle: { $regex: search, $options: 'i' } });
	return res.status(200).json(article);
})


app.post('/retrieveArticleByTitle', async (req, res) => {
	const { search } = req.body;

	console.log('search', search);

	if (isNil(search)) {
		return res.status(400).json('il campo di ricerca è obbligatorio');
	}

	const searchItemReplace = search.replaceAll("+", " ");
	console.log('searchItemReplace', searchItemReplace);
	const searchItemComplete = searchItemReplace.replaceAll("=", "");
	console.log('searchItemComplete', searchItemComplete);
	const searchItemComplete2 = searchItemComplete.replaceAll("%20", " ");
	console.log('searchItemComplete2', searchItemComplete2);

	const article = await ArticleModel.findOne({ titleArticle: { $regex: searchItemComplete2, $options: 'i' } });
	console.log('article', article);
	return res.status(200).json(article);
})

app.post('/upload', async (req, res) => {
	const { listImage } = req.body;

	if (isNilAndLengthPlusZeroArray(listImage)) {
		return res.status(400).json('il campo lista immagini è obbligatorio');
	}

	const actualDate = new Date().toISOString();
	console.log('actualDate', actualDate);

	const image = await ImageModel.create({ listImage: listImage, dataDiInserimento: actualDate });
	return res.status(200).json(image);
})

app.get('/getImg', async (req, res) => {
	const imageList = await ImageModel.find({});
	return res.status(200).json(imageList);
})


server.listen(PORT, () => {
	console.log(`Listening on port ${PORT}`);
});



