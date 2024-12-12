const mongoose = require('mongoose');
const {Schema} = mongoose;

const ArticleSchema = new Schema({
	titleArticle: {
		type: String,
		required: true
	},
    bodyArticle: {
		type: String,
		required: true
	},
	imgCopertina: {
		type: String,
		required: true	
	},
	category: {
		type: String,
		required: true
	},
	subTitle: {
		type: String,
		required: true
	},
	dataPubblicazione: {
		type: Date,
		required: true
	}
});

const ArticleModel = mongoose.model('blogposts', ArticleSchema, 'blogposts');

module.exports = ArticleModel;