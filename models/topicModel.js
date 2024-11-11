const mongoose = require('mongoose');
const {Schema} = mongoose;

const TopicSchema = new Schema({
	topicTitle: {
		type: String,
		required: true
	}
});

const TopicModel = mongoose.model('topics', TopicSchema);

module.exports = TopicModel;