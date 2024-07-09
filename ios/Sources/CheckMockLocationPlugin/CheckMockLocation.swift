import Foundation

@objc public class CheckMockLocation: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
