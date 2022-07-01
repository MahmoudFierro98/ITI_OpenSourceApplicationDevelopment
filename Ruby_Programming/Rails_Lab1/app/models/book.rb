class Book < ApplicationRecord
    validates :name, presence: true, length: {minimum:3}
    validates :price, presence: true
    validates :image,presence: true
    validates :description,presence: true

    belongs_to :user
    
end
