const mongoose = require('mongoose');
const {Schema} = mongoose;

const CategorySchema = new Schema({
	categoryTitle: {
		type: String,
		required: true
	}
});

const CategoryModel = mongoose.model('category_post', CategorySchema);

module.exports = CategoryModel;