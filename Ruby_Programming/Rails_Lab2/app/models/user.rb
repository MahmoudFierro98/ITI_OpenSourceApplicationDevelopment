class User < ApplicationRecord
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable, :trackable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable ,:validatable
  belongs_to :role
  has_many :books , dependent: :destroy

  validates :name, presence: true
  before_save :assign_role
  after_create :send_confirmation_email

  private

  def send_confirmation_email
    UserMailer.with(user: self ).welcome_email.deliver_now 
  end

  def assign_role
    self.role=Role.find_by name: 'Regular' if role.nil?
  end

  def admin?
    role.name == 'Admin'
  end

  def seller?
    role.name == 'Seller'
  end

  def regular?
    role.name == 'Regular'
  end

end
