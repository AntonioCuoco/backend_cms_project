const mongoose = require('mongoose');
const {Schema} = mongoose;

const ImageSchema = new Schema({
	listImage: {
		type: Array,
		required: true
	},
	dataDiInserimento: {
		type: Date,
		required: true
	}
});

const ImageModel = mongoose.model('images', ImageSchema, 'images');

module.exports = ImageModel;