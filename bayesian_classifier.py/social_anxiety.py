import numpy as np
from sklearn import preprocessing
from sklearn.naive_bayes import GaussianNB
from flask import Flask
from flask_restful import reqparse, abort, Api, Resource

# Initialise Flask App
app = Flask(__name__)
api = Api(app)

# For labelling the dataset
le = preprocessing.LabelEncoder()

# Creating a Gaussian classifier
model = GaussianNB()

# Adding 'query' argument to the HTTP request
parser = reqparse.RequestParser()
parser.add_argument('query')

class PredictResult(Resource):
    def get(self):
        # Use parser and find the user's query
        args = parser.parse_args()
        user_query = args['query']
        user_query = user_query.split(',')
        user_query = list(map(int, user_query))

        # Sample dataset
        feeling = ['anxious', 'anxious', 'alone', 'depressed', 'okay', 'sad', 'afraid', 'anxious', 'anxious', 'anxious', 'excited', 'tired', 'bored', 'happy']
        behaviour = ['social media', 'friends', 'work', 'social media', 'family', 'health', 'college', 'work', 'social media', 'friends', 'family', 'work', 'partner', 'work']
        alone = ['yes', 'yes', 'sometimes', 'no', 'yes', 'sometimes', 'no', 'no', 'sometimes', 'no', 'no', 'sometimes', 'sometimes', 'no']
        negativity = ['very often', 'often', 'often', 'sometimes', 'sometimes', 'rarely', 'sometimes', 'rarely', 'sometimes', 'never', 'rarely', 'sometimes', 'rarely', 'never']
        rejection = ['very often', 'very often', 'very often', 'sometimes', 'sometimes', 'often', 'sometimes', 'rarely', 'never', 'sometimes', 'rarely', 'rarely', 'rarely', 'never']
        result = ['yes', 'yes', 'yes', 'yes', 'no', 'yes', 'yes', 'no', 'no', 'yes', 'no', 'no', 'no', 'no']

        # Label encoding
        feeling_encoded = le.fit_transform(feeling)
        behaviour_encoded = le.fit_transform(behaviour)
        alone_encoded = le.fit_transform(alone)
        negativity_encoded = le.fit_transform(negativity)
        rejection_encoded = le.fit_transform(rejection)
        result_encoded = le.fit_transform(result)

        # Combining all criterias together
        features = zip(feeling_encoded,behaviour_encoded,alone_encoded,negativity_encoded,rejection_encoded)

        # Traning the Gausian classifier using the training set
        model.fit(list(features),result_encoded)

        # Passing custom data to the trained model
        predicted = model.predict([user_query])

        val = np.float32(predicted[0])

        # Output JSON
        output = { 'social_anxiety': val.item() }

        # Outshelling the result
        return (output)


# Setup the Api resource routing here
# Route the URL to the resource
api.add_resource(PredictResult, '/')


if __name__ == '__main__':
    app.run(debug=True)