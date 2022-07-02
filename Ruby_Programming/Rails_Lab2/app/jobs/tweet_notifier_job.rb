class TweetNotifierJob < ApplicationJob
  queue_as :default

  def perform(*args)
    # Do something later

    TweetNotifierJob.new(tweet).notify
  end
end
